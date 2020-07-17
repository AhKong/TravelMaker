package com.cafe24.travelMaker.controller;
import java.time.LocalTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.Res;
import com.cafe24.travelMaker.service.ResService;
import com.cafe24.travelMaker.service.ReviewService;
import com.cafe24.travelMaker.service.SightsService;
import com.cafe24.travelMaker.service.StorageService;
@Controller
@RequestMapping("/res")
public class ResController {
	@Autowired private ResService resService;
	@Autowired private SightsService sightsService;
	@Autowired private StorageService storageService;
	@Autowired private ReviewService reviewService;

	@GetMapping("/resList")
	public String resList(Model model, @RequestParam (name="search") String search) {
		System.out.println(search +"<---search");
		System.out.println(resService.getResList(search));
		model.addAttribute("search", search);
		model.addAttribute("resList", resService.getResList(search));
		model.addAttribute("best3", resService.getbestRes(search));
		return "/res/resList";
	}
	
	@GetMapping("/addRes")
	public String addRes(Model model) {
		model.addAttribute("resList", resService.selectResCate());
		model.addAttribute("doList",sightsService.selectDo());
		return "/res/addRes";
	}
	
	@PostMapping("/addRes")
	public String addRes(Res res) {
		System.out.println(res+"<----res");
		res.setResPhoto(res.getFile().getOriginalFilename());
		if(!"".equals(res.getResPhoto())) {
			storageService.store(res.getFile());
		}
		int result = resService.addRes(res);
		System.out.println(result +"<---addRes result ");
		return "redirect:/";
	}
	
	@GetMapping("/updateRes")
	public String udpateRes() {
		return "/res/updateRes";
	}
	
	@GetMapping("/deleteRes") 
	public String deleteRes() {
		return "res/deleteRes";
	}
	
	@GetMapping("/resDetail")
	public String detailRes(Model model, @RequestParam(name="resNum") String resNum,HttpSession session) {
		String mId = (String) session.getAttribute("SID");
		System.out.println(resService.getDetailRes(resNum));
		model.addAttribute("res",resService.getDetailRes(resNum));
		model.addAttribute("tripType",reviewService.selectTripTypeList());
		model.addAttribute("isWrited", reviewService.isWritedReview(mId, resNum));
		model.addAttribute("reviewList",reviewService.resReviewList(resNum,mId));
		model.addAttribute("reviewCnt",reviewService.getResReviewGradeCnt(resNum));
		model.addAttribute("gradeAvg", reviewService.getGradeAvg(resNum));
		model.addAttribute("reviewCnt", reviewService.getReviewCnt(resNum));
		System.out.println(reviewService.resReviewList(resNum,mId) +"<---");
		return "res/detailRes";
	}
	
	@GetMapping("/moreResPhoto")
	public String moreResPhoto() {
		return "res/morePhotos";
	}

}
