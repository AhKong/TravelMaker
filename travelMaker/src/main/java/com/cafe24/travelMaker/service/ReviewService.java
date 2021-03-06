package com.cafe24.travelMaker.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Preference;
import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.TripType;
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
	
	public int deleteResReview(String ResReviewNum) {
		return reviewMapper.deleteResReview(ResReviewNum);
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
	public double getResGradeAvg(String resNum) {
		String gradeAvg = reviewMapper.getResGradeAvg(resNum);
		double result = 0;
		if(gradeAvg !=null) {
		   result = Double.parseDouble(gradeAvg);
		}
		return result;
	}
	
	public int getResReviewCnt(String resNum) {
		String reviewCtn = reviewMapper.getResReviewCnt(resNum);
		int result =0;

		if(reviewCtn !=null) {
			result = Integer.parseInt(reviewCtn);
		}
		return result;
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
	
	public int deleteSightsReview(String sightsReviewNum) {
		return reviewMapper.deleteSightsReview(sightsReviewNum);
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
	
	public ResReview getResReviewInfo(String resReviewNum) {
		return reviewMapper.getResReviewInfo(resReviewNum);
	}
	
	public SightsReview getSightsReviewInfo(String sightsReviewNum) {
		return reviewMapper.getSightsReviewInfo(sightsReviewNum);
	}
	
	public List<ResReview> followersResReviewList(String mId) {
		return reviewMapper.followersResReviewList(mId);
	}
	public List<SightsReview> followersSightsReviewList(String mId) {
		return reviewMapper.followersSightsReviewList(mId);
	}
	
	public List<ReviewGrade> getSightsReviewGradeCnt(String sightsNum){
		return reviewMapper.getSightsReviewGradeCnt(sightsNum);
	}
	
	public double getSightsGradeAvg(String sightsNum) {
		String gradeAvg = reviewMapper.getSightsGradeAvg(sightsNum);
		double result = 0;
		if(gradeAvg !=null) {
		   result = Double.parseDouble(gradeAvg);
		}
		return result;
	}
	
	public int getSightsReviewCnt(String sightsNum) {
		String reviewCtn = reviewMapper.getSightsReviewCnt(sightsNum);
		int result =0;
		if(reviewCtn !=null) {
			result = Integer.parseInt(reviewCtn);
		}
		return result;
	}
	
	public List<String> getResReviewPhotos(String resNum){
		return reviewMapper.getResReviewPhotos(resNum);
	}
	public List<String> getSightsReviewPhotos(String sightsNum){
		return reviewMapper.getSightsReviewPhotos(sightsNum);
	}
	
	public String getSightsGenderPreference(String sightsNum){
		String gender = null;
		List<Preference>result = reviewMapper.getSightsGenderPreference(sightsNum);
		if(result.size() !=0) {
			if(result.size()==1) {
				gender = result.get(0).getType();
			} else {
				if(result.get(0).getCount()>result.get(1).getCount()) {
					gender = result.get(0).getType();
				} else if(result.get(0).getCount()<result.get(1).getCount()){
					gender = result.get(1).getType();
				}  
				else {
					gender ="all";
				}
			}
					
		}
		
		return gender;
	}
	
	public String getResGenderPreference(String resNum){
		String gender = null;
		List<Preference>result = reviewMapper.getResGenderPreference(resNum);
		if(result.size() !=0) {
			if(result.size()==1) {
				gender = result.get(0).getType();
			} else {
				if(result.get(0).getCount()>result.get(1).getCount()) {
					gender = result.get(0).getType();
				} else if(result.get(0).getCount()<result.get(1).getCount()){
					gender = result.get(1).getType();
				} else {
					gender ="all";
				}
			}
					
		}
		
		return gender;
	}
	
	public int changeResReivewStatus(String reviewNum) {
		return reviewMapper.changeResReivewStatus(reviewNum);
	}
	
	public int changeSightsReivewStatus(String reviewNum) {
		return reviewMapper.changeSightsReivewStatus(reviewNum);
	}
	
	public String findSightsReviewWriter(String reviewNum) {
		return reviewMapper.findSightsReviewWriter(reviewNum);
	}
	public String findResReviewWriter(String reviewNum) {
		return reviewMapper.findResReviewWriter(reviewNum);
	}
}
