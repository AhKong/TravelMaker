package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import com.cafe24.travelMaker.domain.FbCode;
import com.cafe24.travelMaker.domain.FeedbackRes;
import com.cafe24.travelMaker.domain.FeedbackSights;

@Mapper
public interface FeedbackMapper {

	//회원 -> 관광명소, 음식점 피드백 폼으로 이동
	public List<FbCode> addFeedback(FbCode fbCode);
	
	//회원 -> 관광명소 피드백 보내기
	public int addSightsFeedback(FeedbackSights feedbackSights);
	
	//회원 -> 음식점 피드백 보내기
	public int addResFeedback(FeedbackRes feedbackRes);
	
	//관리자 -> 관광명소 피드백 리스트
	public List<FeedbackSights> fbSightsList(Model model);
	
	//관리자  -> 음식점 피드백 리스트
	public List<FeedbackRes> fbResList(Model model);
	
	//관리자 -> 관광명소 피드백 수용
	public int acceptFbSights(String fbSightsCheck, String fbSightsNum);
	
	//관리자 -> 음식점 피드백 수용
	public int acceptFbRes(String fbResCheck, String fbResNum);
}
