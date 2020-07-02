package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.TripType;
import com.cafe24.travelMaker.mapper.ReviewMapper;

@Service
public class ReviewService {
	@Autowired private ReviewMapper reviewMapper;
	
	public List<TripType> selectTripTypeList(){
		return  reviewMapper.selectTripTypeList();
	}
	
	public int addResReview (ResReview resReview) {
		return reviewMapper.addResReview(resReview);
	}
	
	public int isWritedReview(String mId, String resNum) {
		return reviewMapper.isWritedReview(mId, resNum);
	}

}
