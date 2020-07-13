package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.ReviewGrade;
import com.cafe24.travelMaker.domain.SightsReview;
import com.cafe24.travelMaker.domain.TripType;

@Mapper
public interface ReviewMapper {
	public List<TripType> selectTripTypeList();
	public int addResReview(ResReview resReview);
	public int isWritedResReview(String mId, String resNum);
	public List<ResReview> resReviewList(String resNum);
	public List<ReviewGrade> getResReviewGradeCnt(String resNum);
	public int isLikedResReview(String mId, String reviewNum);
	public int deleteResReview(String resReviewNum) ;
	
	public int addSightsReview(SightsReview sightsReview);
	public List<SightsReview> sightsReviewList(String sightsNum);
	public int isLikedSightsReview(String mId,String reviewNum);
	public int isWritedSightsReview(String mId, String sightsNum);
	public int deleteSightsReview(String sightsReviewNum) ;
	public SightsReview getSightsReviewInfo(String sightsReviewNum);
	public ResReview getResReviewInfo(String resReviewNum);
	
}
