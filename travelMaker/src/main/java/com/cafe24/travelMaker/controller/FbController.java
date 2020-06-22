package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.travelMaker.service.FeedbackService;

@Controller
public class FbController {

@Autowired FeedbackService feedbackService;
	
	//피드백 등록하기
	@GetMapping("/addFeedback")
	public String addFeedback() {
		
		return "feedback/addFeedback";
	}
	
	//피드백 리스트
	@GetMapping("/feedbackList")
	public String feedbackList() {
		
		return "feedback/feedbackList";
	}
	
	
}
