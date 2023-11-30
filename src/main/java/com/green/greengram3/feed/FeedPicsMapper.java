package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedPicsMapper {
    int insFeedPics(FeedInsDto p);
}
