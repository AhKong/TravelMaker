package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.travelMaker.domain.FbCode;
import com.cafe24.travelMaker.domain.FeedbackSights;
import com.cafe24.travelMaker.mapper.FeedbackMapper;

@Service
public class FeedbackService {

@Autowired FeedbackMapper feedbackMapper;

	//피드백 폼으로 이동
	public List<FbCode> formFeedback(FbCode fbCode) {
		System.out.println("formFeedback FeedbackService 도착");
		List<FbCode> fCode = feedbackMapper.formFeedback(fbCode);
		System.out.println(fCode+" <- fCode addFeedback FeedbackService");
		
		return fCode;
	}

	//피드백 전송
	public int addFeedback(FeedbackSights feedbackSights) {
		System.out.println("addFeedback FeedbackService 도착");
		System.out.println(feedbackSights+" <- feedbackSights addFeedback FeedbackService");
		int num = feedbackMapper.addFeedback(feedbackSights);
		System.out.println(num+" <- result addFeedback Feedbackservice");
		
		return num;
	}
	
	//피드백 리스트
	public List<FeedbackSights> feedbackList(Model model){
		System.out.println("feedbackList FeedbackService 도착");
		List<FeedbackSights> fbList = feedbackMapper.feedbackList(model);
		System.out.println(fbList+" <- fbList feedbackList FeedbackService");
		
		return fbList;
	}
	
	//피드백 수용 버튼
	public int acceptFeedback(String fbSightsCheck, String fbSightsNum) {
		System.out.println("acceptFeedback FeedbackService 도착");
		System.out.println(fbSightsCheck+" <- fbSightsCheck / "+fbSightsNum+" <- fbSightsNum");
		int fbResult = feedbackMapper.acceptFeedback(fbSightsCheck, fbSightsNum);
		System.out.println(fbResult+" <- fbResult acceptFeedback FeedbackService");
		
		return fbResult;
	}
	
}
