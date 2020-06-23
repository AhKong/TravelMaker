package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.SightsFeedback;
import com.cafe24.travelMaker.service.FeedbackService;

@Controller
public class FbController {

@Autowired FeedbackService feedbackService;
	
	//피드백 등록 폼으로 이동
	@GetMapping("/addfeedback")
	public String addFeedback(Model model, @RequestParam(name="sightsNum", required=false) String sightsNum) {
		System.out.println("addFeedback FbController 도착");
		System.out.println(sightsNum+" <- sightsNum 값 들어왔나요");
		String result = feedbackService.formFeedback(sightsNum);
		System.out.println(result+" <- result addFeedback FbController");
		
		return "feedback/addFeedback";
	}
	
	//피드백 등록
	@PostMapping("/addFeedback")
	public String addFeedback(SightsFeedback sightsFeedback) {
		System.out.println("addFeedback FbController 도착");
		System.out.println(sightsFeedback+" <- sightsFeedback addFeedback FbController");
		int result = feedbackService.addFeedback(sightsFeedback);
		System.out.println(result+" <- result addFeedback FbController");
		
		return "feedback/addFeedback";
	}
	
	//피드백 리스트
	@GetMapping("/feedbackList")
	public String feedbackList() {
		
		return "feedback/feedbackList";
	}
	
}
