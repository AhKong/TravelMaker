package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cafe24.travelMaker.mapper.FeedbackMapper;

@Service
public class FeedbackService {

@Autowired FeedbackMapper feedbackMapper;

	public int addFeedback() {
		
		return 0;
	}
	
}
