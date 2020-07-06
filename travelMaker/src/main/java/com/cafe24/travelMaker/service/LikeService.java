package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ReviewLike;
import com.cafe24.travelMaker.mapper.LikeMapper;

@Service
public class LikeService {
	@Autowired private LikeMapper likeMapper;
	public int likeResReview(ReviewLike reviewLike) {
		return likeMapper.likeResReview(reviewLike);
	}
	public int unLikeResReview(ReviewLike reviewLike) {
		return likeMapper.unLikeResReview(reviewLike);
	}
}
