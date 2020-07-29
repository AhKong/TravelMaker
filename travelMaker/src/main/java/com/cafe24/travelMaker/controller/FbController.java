package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.cafe24.travelMaker.service.NoticeService;
import com.cafe24.travelMaker.service.PointService;

@Controller
@RequestMapping("/feedback")
public class FbController {

@Autowired FeedbackService feedbackService;
@Autowired PointService pointService;
@Autowired NoticeService noticeService;
	
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
	
	//관리자 -> 관광명소/음식점 피드백 수용 -> 관광명소/음식점 수정페이지로 이동
	@GetMapping("/acceptFeedback")
	public String acceptFbSights(Model model, HttpSession session, 
												@RequestParam(name="fbSightsCheck", required=false) String fbSightsCheck,
												@RequestParam(name="fbSightsNum", required=false) String fbSightsNum,
												@RequestParam(name="sightsNum", required=false) String sightsNum,
												@RequestParam(name="fbResCheck", required=false) String fbResCheck,
												@RequestParam(name="fbResNum", required=false) String fbResNum,
												@RequestParam(name="resNum", required=false) String resNum,
												@RequestParam(name="mId", required=false) String mId) {
		System.out.println("(Get) acceptFbSights FbController 도착");
		System.out.println(fbSightsCheck+" <- fbSightsCheck / "+fbSightsNum+" <- fbSightsNum");
		System.out.println(fbResCheck+" <- fbResCheck / "+fbResNum+" <- fbResNum");
		if(sightsNum != null && resNum == null) {
			int result = feedbackService.acceptFbSights(fbSightsCheck, fbSightsNum);	//피드백 수용여부 변경
			pointService.savePointForFeedback(session, sightsNum, resNum, mId);			//포인트 지급 + 알람
			System.out.println(sightsNum+" <- sightsNum");
			System.out.println(fbSightsNum+" <- fbSightsNum");
			model.addAttribute("sightsNum", sightsNum);
			model.addAttribute("fbSightsNum", fbSightsNum);
					
			return "sights/updateSights";
			
		}else if(sightsNum == null && resNum != null) {
			int result = feedbackService.acceptFbRes(fbResCheck, fbResNum);
			System.out.println(resNum+" <- resNum");
			System.out.println(fbResNum+" <- fbResNum");
			model.addAttribute("resNum", resNum);
			model.addAttribute("fbResNum", fbResNum);
			
			return "res/updateRes";
			
		}else {
			return "redirect:/main";
		}
	}
	
	//관리자 -> 관광명소 피드백 무시
	@GetMapping("/ignoreFbSights")
	public String ignoreFbSights(Model model, @RequestParam(name="fbSightsCheck", required=false) String fbSightsCheck,
	  										  @RequestParam(name="fbSightsNum", required=false) String fbSightsNum,
	  										  @RequestParam(name="sightsNum", required=false) String sightsNum) {
		System.out.println("(Get) ignoreFbSights FbController 도착");
		System.out.println(fbSightsCheck+" <- fbSightsCheck / "+fbSightsNum+" <- fbSightsNum");
		int result = feedbackService.acceptFbSights(fbSightsCheck, fbSightsNum);
				
		return "redirect:/feedback/feedbackList";
	}

	//관리자 -> 음식점 피드백 무시
	@GetMapping("/ignoreFbRes")
	public String ignoreFbRes(Model model, @RequestParam(name="fbResCheck", required=false) String fbResCheck,
										   @RequestParam(name="fbResNum", required=false) String fbResNum,
										   @RequestParam(name="resNum", required=false) String resNum) {
		System.out.println("(Get) ignoreFbRes FbController 도착");
		System.out.println(fbResCheck+" <- fbResCheck / "+fbResNum+" <- fbResNum");
		int result = feedbackService.acceptFbRes(fbResCheck, fbResNum);
		
		return "redirect:/feedback/feedbackList";
	}
}
