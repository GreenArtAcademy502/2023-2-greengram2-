package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsDto p);
}
