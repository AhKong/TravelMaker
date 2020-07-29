package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.travelMaker.domain.FbCode;
import com.cafe24.travelMaker.domain.FeedbackRes;
import com.cafe24.travelMaker.domain.FeedbackSights;
import com.cafe24.travelMaker.mapper.FeedbackMapper;

@Service
public class FeedbackService {

@Autowired FeedbackMapper feedbackMapper;

	//회원 -> 관광명소, 음식점 피드백 등록 폼으로 이동
	public List<FbCode> addFeedback(FbCode fbCode) {
		System.out.println("formFeedback FeedbackService 도착");
		List<FbCode> fCode = feedbackMapper.addFeedback(fbCode);
		System.out.println(fCode+" <- fCode addFeedback FeedbackService");
		
		return fCode;
	}

	//회원 -> 관광명소 피드백 등록
	public int addSightsFeedback(FeedbackSights feedbackSights) {
		System.out.println("addSightsFeedback FeedbackService 도착");
		System.out.println(feedbackSights+" <- feedbackSights addSightsFeedback FeedbackService");
		int num = feedbackMapper.addSightsFeedback(feedbackSights);
		System.out.println(num+" <- 1 이면 관광명소 피드백 등록 완료!");
		
		return num;
	}
	
	//회원 -> 음식점 피드백 등록
	public int addResFeedback(FeedbackRes feedbackRes) {
		System.out.println("addSightsFeedback FeedbackService 도착");
		System.out.println(feedbackRes+" <- feedbackSights addSightsFeedback FeedbackService");
		int num = feedbackMapper.addResFeedback(feedbackRes);
		System.out.println(num+" <- 1 이면 음식점 피드백 등록 완료!");
		
		return num;
	}
	
	//관리자 -> 관광명소 피드백 리스트
	public List<FeedbackSights> fbSightsList(Model model){
		System.out.println("fbSightsList FeedbackService 도착");
		List<FeedbackSights> fbSightsList = feedbackMapper.fbSightsList(model);
		System.out.println(fbSightsList+" <- fbSightsList FeedbackService");
		
		return fbSightsList;
	}
	
	//관리자 -> 음식점 피드백 리스트
	public List<FeedbackRes> fbResList(Model model){
		System.out.println("fbResList FeedbackService 도착");
		List<FeedbackRes> fbResList = feedbackMapper.fbResList(model);
		System.out.println(fbResList+" <- fbResList FeedbackService");
		
		return fbResList;
	}
	
	//관리자 -> 관광명소 피드백 수용/무시 버튼
	public int acceptFbSights(String fbSightsCheck, String fbSightsNum) {
		System.out.println("acceptFbSights FeedbackService 도착");
		int result = feedbackMapper.acceptFbSights(fbSightsCheck, fbSightsNum);
		System.out.println(result+" <- 1이면 관광명소 피드백 수용여부 업데이트 완료!");
		
		return result;
	}
	
	//관리자 -> 음식점 피드백 수용/무시 버튼
	public int acceptFbRes(String fbResCheck, String fbResNum) {
		System.out.println("acceptFbRes FeedbackService 도착");
		int result = feedbackMapper.acceptFbRes(fbResCheck, fbResNum);
		System.out.println(result+" <- 1이면 음식점 피드백 수용여부 업데이트 완료!");
		
		return result;
	}
	
}
