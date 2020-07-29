package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.travelMaker.domain.ReviewLike;
import com.cafe24.travelMaker.mapper.LikeMapper;

@Service
@Transactional
public class LikeService {
	@Autowired private LikeMapper likeMapper;
	@Autowired private NoticeService noticeService;
	
	public int likeResReview(ReviewLike reviewLike,String reviewWriter) {
	
		if(!reviewLike.getmId().equals(reviewWriter)) {
			noticeService.addNoticeForLike(reviewWriter, reviewLike);
		}
		return likeMapper.likeResReview(reviewLike);
	}
	public int unLikeResReview(ReviewLike reviewLike) {
		return likeMapper.unLikeResReview(reviewLike);
	}
	
	public int likeSightsReview(ReviewLike reviewLike,String reviewWriter) {
		if(!reviewLike.getmId().equals(reviewWriter)) {
			noticeService.addNoticeForLike(reviewWriter, reviewLike);
		}
		return likeMapper.likeSightsReview(reviewLike);
	}
	public int unLikeSightsReview(ReviewLike reviewLike) {
		return likeMapper.unLikeSightsReview(reviewLike);
	}
}
