package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.SightsFeedback;
import com.cafe24.travelMaker.mapper.FeedbackMapper;

@Service
public class FeedbackService {

@Autowired FeedbackMapper feedbackMapper;

	public String formFeedback(String sightsNum) {
		System.out.println("formFeedback FeedbackService 도착");
		System.out.println(sightsNum+" <- sightsNum formFeedback FeedbackService");
		String result = feedbackMapper.formFeedback(sightsNum);
		System.out.println(result+" <- result formFeedback FeedbackService");
		
		return result;
	}

	public int addFeedback(SightsFeedback sightsFeedback) {
		System.out.println("addFeedback FeedbackService 도착");
		System.out.println(sightsFeedback+" <- sightsFeedback addFeedback FeedbackService");
		int result = feedbackMapper.addFeedback(sightsFeedback);
		System.out.println(result+" <- result addFeedback Feedbackservice");
		
		return result;
	}
	
}
