package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.travelMaker.domain.FeedbackSights;
import com.cafe24.travelMaker.mapper.FeedbackMapper;

@Service
public class FeedbackService {

@Autowired FeedbackMapper feedbackMapper;

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
	
}
