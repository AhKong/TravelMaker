package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import com.cafe24.travelMaker.domain.Si;
import com.cafe24.travelMaker.domain.Sights;
import com.cafe24.travelMaker.service.MyTripService;
import com.cafe24.travelMaker.service.ReviewService;
import com.cafe24.travelMaker.service.SightsService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
@RequestMapping("/sights")
public class SightsController{
	@Autowired private SightsService sightsService;
	@Autowired private StorageService storageService;
	@Autowired private ReviewService reviewService;

	@GetMapping("/sightsList")
	public String sightsList(Model model,@RequestParam(name="search") String search,HttpSession session) {
		System.out.println(search+"<---");
		model.addAttribute("searchWord", search);
		model.addAttribute("sightsList", sightsService.selectSightsList(search));
		model.addAttribute("best3", sightsService.getbestSights(search));
		return "/sights/sightsList";
	}
	
	
	@GetMapping ("/addSights")
	public String addSights(Model model) {
		model.addAttribute("cateList", sightsService.selectSightsCate());
		model.addAttribute("doList",sightsService.selectDo());
		return "/sights/addSights";
	}
	
	@PostMapping("/addSights")
	public String addSights(Sights sights) {
		System.out.println(sights +"<---sights");
		sights.setSightsPhoto(sights.getFile().getOriginalFilename());
		if(!"".equals(sights.getSightsPhoto())) {
			storageService.store(sights.getFile());
		}
		int result = sightsService.addSights(sights);
		if(result >0) {
			return "redirect:/addSights";
		}
		
		return "redirect:/";
	}
	@GetMapping("/updateSights")
	public String updateSights() {
		return "/sights/updateSights";
	}
	
	@GetMapping("/detailSights")
	public String detailSights(Model model, @RequestParam(name="sightsNum") String sightsNum,HttpSession session) {
		String mId = (String) session.getAttribute("SID");
		model.addAttribute("sights", sightsService.getDetailSights(sightsNum));
		model.addAttribute("tripType",reviewService.selectTripTypeList());
		model.addAttribute("reviewList",reviewService.sightsReviewList(sightsNum,mId));
		model.addAttribute("isWrited",reviewService.isWritedSightsReview(mId, sightsNum));
		model.addAttribute("reviewGradeCnt",reviewService.getSightsReviewGradeCnt(sightsNum));
		model.addAttribute("gradeAvg", reviewService.getSightsGradeAvg(sightsNum));
		model.addAttribute("reviewCnt", reviewService.getSightsReviewCnt(sightsNum));
		model.addAttribute("reviewPhotos", reviewService.getSightsReviewPhotos(sightsNum));
		model.addAttribute("genderPreference", reviewService.getSightsGenderPreference(sightsNum));
		model.addAttribute("typePreference", reviewService.getSightsTypePreference(sightsNum));
	
		return "/sights/detailSights";
	}
	
	@GetMapping("/moreSightsPhoto")
	public String moreSightsPhoto(Model model, @RequestParam(name="sightsNum") String sightsNum) {
		model.addAttribute("sights", sightsService.getDetailSights(sightsNum));
		model.addAttribute("reviewPhotos", reviewService.getSightsReviewPhotos(sightsNum));
		return "/sights/morePhotos";
	}
}
