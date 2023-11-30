package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedInsProcDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicsMapper picsMapper;

    public ResVo postFeed(FeedInsDto dto) {
        FeedInsProcDto pDto = FeedInsProcDto.builder()
                .iuser(dto.getIuser())
                .contents(dto.getContents())
                .location(dto.getLocation())
                .pics(dto.getPics())
                .build();

        int feedAffectedRows = mapper.insFeed(pDto);
        int feedPicsAffectedRows = picsMapper.insFeedPics(pDto);

        return new ResVo(pDto.getIfeed());
    }
}
