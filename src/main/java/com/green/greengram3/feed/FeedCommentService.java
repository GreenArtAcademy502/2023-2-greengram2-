package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedCommentInsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    public ResVo postFeedComment(FeedCommentInsDto dto) {
        int affectedRows = mapper.insFeedComment(dto);
        return new ResVo(dto.getIfeedComment());
    }
}
