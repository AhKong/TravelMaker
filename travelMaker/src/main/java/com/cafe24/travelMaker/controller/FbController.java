package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FbController {

	
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
