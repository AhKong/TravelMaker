package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.ReviewLike;

@Mapper
public interface LikeMapper {
	public int likeResReview(ReviewLike reviewLike);
	public int unLikeResReview(ReviewLike reviewLike);
	public int unLikeSightsReview(ReviewLike reviewLike);
	public int likeSightsReview(ReviewLike reviewLike);
}
