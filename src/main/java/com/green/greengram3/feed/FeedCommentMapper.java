package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedCommentInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedCommentMapper {
    int insFeedComment(FeedCommentInsDto dto);
}
