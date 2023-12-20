package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedSelDto;
import com.green.greengram3.feed.model.FeedSelVo;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@Import({ FeedService.class })
class FeedServiceTest {
    @MockBean private FeedMapper mapper;
    @MockBean private FeedPicsMapper picsMapper;
    @MockBean private FeedFavMapper favMapper;
    @MockBean private FeedCommentMapper commentMapper;
    @Autowired private FeedService service;

    @Test
    void postFeed() {
        when(mapper.insFeed(any())).thenReturn(1);
        when(picsMapper.insFeedPics(any())).thenReturn(2);

        FeedInsDto dto = new FeedInsDto();
        dto.setIfeed(100);
        ResVo vo = service.postFeed(dto);
        assertEquals(dto.getIfeed(), vo.getResult());

        verify(mapper).insFeed(any());
        verify(picsMapper).insFeedPics(any());

        FeedInsDto dto2 = new FeedInsDto();
        dto2.setIfeed(200);
        ResVo vo2 = service.postFeed(dto2);
        assertEquals(dto2.getIfeed(), vo2.getResult());
    }

    @Test
    public void getFeedAll() {
        FeedSelVo feedSelVo1 = new FeedSelVo();
        feedSelVo1.setIfeed(1);
        feedSelVo1.setContents("일번 feedSelVo");


        FeedSelVo feedSelVo2 = new FeedSelVo();
        feedSelVo2.setIfeed(2);
        feedSelVo2.setContents("이번 feedSelVo");

        List<FeedSelVo> list = new ArrayList();
        list.add(feedSelVo1);
        list.add(feedSelVo2);

        when( mapper.selFeedAll(any()) ).thenReturn(list);


        List<String> feed1Pics = Arrays.stream( new String[]{ "a.jpg", "b.jpg" } ).toList();

        List<String> feed2Pics = new ArrayList();
        feed2Pics.add("가.jpg");
        feed2Pics.add("나.jpg");

        List<List<String>> picsList = new ArrayList<>();
        picsList.add(feed1Pics);
        picsList.add(feed2Pics);

        //List<String>[] picsArr2 = (List<String>[])picsList.toArray();

        List<String>[] picsArr = new List[2];
        picsArr[0] = feed1Pics;
        picsArr[1] = feed2Pics;

        when( picsMapper.selFeedPicsAll( 1 ) ).thenReturn(feed1Pics);
        when( picsMapper.selFeedPicsAll( 2 ) ).thenReturn(feed2Pics);

        FeedSelDto dto = new FeedSelDto();
        List<FeedSelVo> result = service.getFeedAll(dto);

        assertEquals(list, result);

        for(int i=0; i<list.size(); i++) {
            FeedSelVo vo = list.get(i);
            assertNotNull(vo.getPics());

            List<String> pics = picsList.get(i);
            assertEquals(vo.getPics(), pics);

            List<String> pics2 = picsArr[i];
            assertEquals(vo.getPics(), pics2);
        }
    }












}