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
	
	public List<ResReview> resReviewList(String resNum,String mId){
	
		List<ResReview> reviewList  =  reviewMapper.resReviewList(resNum);
		System.out.println(mId+"<000zjzdfkhk");
		for(int i=0; i<reviewList.size();i++) {
			//해당 리뷰에 좋아요 하지 않은 경우 
			if(isLiked(mId,reviewList.get(i).getResReviewNum())==0) {
				reviewList.get(i).setLiked(false);
			} else {
				reviewList.get(i).setLiked(true);
			}
		}
		return reviewList;
	}
	
	public int isLiked(String mId, String reviewNum) {
		return reviewMapper.isLiked(mId, reviewNum);
	}

}
