package com.cafe24.travelMaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.FeedbackSights;
import com.cafe24.travelMaker.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FbController {

@Autowired FeedbackService feedbackService;
	
	//회원이 피드백 등록 폼으로 이동
	@GetMapping("/addFeedback")
	public String addFeedback(Model model, @RequestParam(name="sightsNum", required=false) String sightsNum) {
		System.out.println("(Get) addFeedback FbController 도착");
		System.out.println(sightsNum+" <- sightsNum addFeedback FbController");
		model.addAttribute("sightsNum", sightsNum);
		
		return "feedback/addFeedback";
	}
	
	//회원이 피드백 등록
	@PostMapping("/addFeedback")
	public String addFeedback(FeedbackSights feedbackSights) {
		System.out.println("(Post) addFeedback FbController 도착");
		System.out.println(feedbackSights+" <- feedbackSights addFeedback FbController");
		System.out.println(feedbackSights.getSights().getSightsNum()+" <- feedbackSights.getSights().getSightsNum()");
		int result = feedbackService.addFeedback(feedbackSights);
		System.out.println(result+" <- result addFeedback FbController");
		
		return "redirect:/sights/detailSights";
	}
	
	//관리자 피드백 리스트
	@GetMapping("/feedbackList")
	public String feedbackList(Model model) {
		System.out.println("(Get) feedbackList FbController 도착 ");
		List<FeedbackSights> fbList = feedbackService.feedbackList(model);
		System.out.println(fbList+" <- fbList feedbackList FbController");
		
		model.addAttribute("fbList", fbList);
		 
		
		return "feedback/feedbackList";
	}
	
	//피드백 수용 버튼
	@GetMapping("/acceptFeedback")
	public String acceptFeedback(Model model, @RequestParam(name="fbSightsCheck", required=false) String fbSightsCheck,
												@RequestParam(name="fbSightsNum", required=false) String fbSightsNum) {
		System.out.println("(Get) acceptFeedback FbController 도착");
		System.out.println(fbSightsCheck+" <- fbSightsCheck / "+fbSightsNum+" <- fbSightsNum");
		int fbResult = feedbackService.acceptFeedback(fbSightsCheck, fbSightsNum);
		System.out.println(fbResult+" <- fbResult acceptFeedback FbController");
		
		return "redirect:/feedback/feedbackList";
	}
	
	
}
