package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.TripType;

@Mapper
public interface ReviewMapper {
	public List<TripType> selectTripTypeList();
	public int addResReview(ResReview resReview);
	public int isWritedReview(String mId, String resNum);
	public List<ResReview> resReviewList(String resNum);
	public List<Integer> getGradeCnt(String resNum);
	

}
