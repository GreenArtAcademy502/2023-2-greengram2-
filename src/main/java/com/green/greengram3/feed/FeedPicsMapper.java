package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedInsProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedPicsMapper {
    int insFeedPics(FeedInsProcDto p);
}
