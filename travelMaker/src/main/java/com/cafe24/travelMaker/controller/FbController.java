package com.cafe24.travelMaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.FbCode;
import com.cafe24.travelMaker.domain.FeedbackRes;
import com.cafe24.travelMaker.domain.FeedbackSights;
import com.cafe24.travelMaker.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FbController {

@Autowired FeedbackService feedbackService;
	
	//회원 -> 관광명소 피드백 등록 폼으로 이동
	@GetMapping("/addSightsFeedback")
	public String addSightsFeedback(Model model, FbCode fbCode,
								@RequestParam(name="sightsNum", required=false) String sightsNum) {
		System.out.println("(Get) addSightsFeedback FbController 도착");
		System.out.println(sightsNum+" <- sightsNum addSightsFeedback FbController");
		List<FbCode> fCode = feedbackService.addFeedback(fbCode);
		model.addAttribute("fCode", fCode);
		model.addAttribute("sightsNum", sightsNum);
		
		return "feedback/addSightsFeedback";
	}
	
	//회원 -> 관광명소 피드백 등록
	@PostMapping("/addSightsFeedback")
	public String addSightsFeedback(FeedbackSights feedbackSights) {
		System.out.println("(Post) addSightsFeedback FbController 도착");
		System.out.println(feedbackSights+" <- addSightsFeedback FbController");
		System.out.println(feedbackSights.getSights().getSightsNum()+" <- feedbackSights.getSights().getSightsNum()");
		int result = feedbackService.addSightsFeedback(feedbackSights);
		System.out.println(result+" <- result addSightsFeedback FbController");
		
		return "redirect:/sights/detailSights";
	}
	
	//회원 -> 음식점 피드백 등록 폼으로 이동
	@GetMapping("/addResFeedback")
	public String addResFeedback(Model model, FbCode fbCode,
								@RequestParam(name="resNum", required=false) String resNum) {
		System.out.println("(Get) addResFeedback FbController 도착");
		System.out.println(resNum+" <- resNum addResFeedback FbController");
		List<FbCode> fCode = feedbackService.addFeedback(fbCode);
		model.addAttribute("fCode", fCode);
		model.addAttribute("resNum", resNum);
		
		return "feedback/addResFeedback";
	}
	
	//회원 -> 음식점 피드백 등록
	@PostMapping("/addResFeedback")
	public String addResFeedback(FeedbackRes feedbackRes) {
		System.out.println("(Post) addSightsFeedback FbController 도착");
		System.out.println(feedbackRes+" <- addSightsFeedback addFeedback FbController");
		System.out.println(feedbackRes.getFbResNum()+" <- feedbackRes.getFbResNum()");
		int result = feedbackService.addResFeedback(feedbackRes);
		
		return "redirect:/res/detailRes";
	}
	
	//관리자 -> 관광명소, 음식점 피드백 리스트
	@GetMapping("/feedbackList")
	public String feedbackList(Model model) {
		System.out.println("(Get) feedbackList FbController 도착 ");
		List<FeedbackSights> fbSightsList = feedbackService.fbSightsList(model);
		List<FeedbackRes> fbResList = feedbackService.fbResList(model);
		System.out.println(fbSightsList+" <- fbSightsList FbController");
		System.out.println(fbResList+" <- fbResList FbController");
		model.addAttribute("fbSightsList", fbSightsList);
		model.addAttribute("fbResList", fbResList);
		
		return "feedback/feedbackList";
	}
	
	//관리자 -> 관광명소 피드백 수용 버튼
	@GetMapping("/acceptFbSights")
	public String acceptFbSights(Model model, @RequestParam(name="fbSightsCheck", required=false) String fbSightsCheck,
	  										  @RequestParam(name="fbSightsNum", required=false) String fbSightsNum) {
		System.out.println("(Get) acceptFbSights FbController 도착");
		System.out.println(fbSightsCheck+" <- fbSightsCheck / "+fbSightsNum+" <- fbSightsNum");
		int result = feedbackService.acceptFbSights(fbSightsCheck, fbSightsNum);
				
		return "redirect:/feedback/feedbackList";
	}
	
	//관리자 -> 음식점 피드백 수용 버튼
	@GetMapping("/acceptFbRes")
	public String acceptFbRes(Model model, @RequestParam(name="fbResCheck", required=false) String fbResCheck,
			@RequestParam(name="fbResNum", required=false) String fbResNum) {
		System.out.println("(Get) acceptFbRes FbController 도착");
		System.out.println(fbResCheck+" <- fbResCheck / "+fbResNum+" <- fbResNum");
		int result = feedbackService.acceptFbRes(fbResCheck, fbResNum);
		
		return "redirect:/feedback/feedbackList";
	}
	
	//관리자 -> 피드백 하러가기 버튼 -> 관광명소 수정페이지로 이동
	@GetMapping("/updateSights")
	public String updateSights(Model model, @RequestParam(name="sightsNum", required=false) String sightsNum,
											@RequestParam(name="fbSightsNum", required=false) String fbSightsNum) {
		System.out.println("(Get) updateSights FbController 도착");
		System.out.println(sightsNum+" <- sightsNum");
		System.out.println(fbSightsNum+" <- fbSightsNum");
		model.addAttribute("sightsNum", sightsNum);
		model.addAttribute("fbSightsNum", fbSightsNum);
		
		return "/sights/updateSights";
	}
	
	//관리자 -> 피드백 하러가기 버튼 -> 관광명소 수정페이지로 이동
	@GetMapping("/updateRes")
	public String updateRes(Model model, @RequestParam(name="resNum", required=false) String resNum,
			@RequestParam(name="fbResNum", required=false) String fbResNum) {
		System.out.println("(Get) updateRes FbController 도착");
		System.out.println(resNum+" <- resNum");
		System.out.println(fbResNum+" <- fbResNum");
		model.addAttribute("resNum", resNum);
		model.addAttribute("fbResNum", fbResNum);
		
		return "/res/updateRes";
	}
	
	
}
