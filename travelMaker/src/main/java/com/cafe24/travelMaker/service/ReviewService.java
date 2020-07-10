package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.TripType;
import com.cafe24.travelMaker.mapper.PointMapper;
import com.cafe24.travelMaker.mapper.ReviewMapper;
import com.cafe24.travelMaker.domain.ReviewGrade;
import com.cafe24.travelMaker.domain.SightsReview;

@Service
public class ReviewService {
	@Autowired private ReviewMapper reviewMapper;
	@Autowired private PointService pointService;
	
	public List<TripType> selectTripTypeList(){
		return  reviewMapper.selectTripTypeList();
	}
	
	public int addResReview (ResReview resReview) {
		int point = 0;
		System.out.println(resReview.getResReviewPhoto());
		if("".equals(resReview.getResReviewPhoto())) {
			point = 1000;
		} else {
			point = 1500;
		}
		pointService.setSavePointForReview(resReview.getMember().getmId(), point, resReview.getResReviewNum());
		return reviewMapper.addResReview(resReview);
	}
	
	public int isWritedReview(String mId, String resNum) {
		return reviewMapper.isWritedResReview(mId, resNum);
	}
	
	public List<ResReview> resReviewList(String resNum,String mId){
		List<ResReview> reviewList  =  reviewMapper.resReviewList(resNum);
		for(int i=0; i<reviewList.size();i++) {
			//해당 리뷰에 좋아요 하지 않은 경우 
			if(isLikedResReview(mId,reviewList.get(i).getResReviewNum())==0) {
				reviewList.get(i).setLiked(false);
			} else {
				reviewList.get(i).setLiked(true);
			}
		}
		return reviewList;
	}
	
	public int isLikedResReview(String mId, String reviewNum) {
		return reviewMapper.isLikedResReview(mId, reviewNum);
	}
	public List<ReviewGrade> getResReviewGradeCnt(String resNum){
		return reviewMapper.getResReviewGradeCnt(resNum);
	}
	
	public int isWritedSightsReview(String mId, String sightsNum) {
		return reviewMapper.isWritedSightsReview(mId, sightsNum);
	}
	
	public int addSightsReview(SightsReview sightsReview) {
		int point = 0;
	
		if("".equals(sightsReview.getSightsReviewPhoto())) {
			point = 1000;
		} else {
			point = 1500;
		}
		pointService.setSavePointForReview(sightsReview.getMember().getmId(), point, sightsReview.getSightsReviewNum());
		return reviewMapper.addSightsReview(sightsReview);
	}
	
	public int isLikedSightsReview(String mId, String reviewNum) {
		return reviewMapper.isLikedSightsReview(mId, reviewNum);
	}
	public List<SightsReview> sightsReviewList(String sightsNum,String mId){
		
		List<SightsReview> reviewList  =  reviewMapper.sightsReviewList(sightsNum);
		for(int i=0; i<reviewList.size();i++) {
			//해당 리뷰에 좋아요 하지 않은 경우 
			if(isLikedSightsReview(mId,reviewList.get(i).getSightsReviewNum())==0) {
				reviewList.get(i).setLiked(false);
			} else {
				reviewList.get(i).setLiked(true);
			}
		}
		return reviewList;
	
	}
	
	
}
