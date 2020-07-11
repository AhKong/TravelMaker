package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.SightsReview;
import com.cafe24.travelMaker.service.ReviewService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired private ReviewService reviewService;
	@Autowired private StorageService storageService;
	
	@PostMapping("/addResReview")
	public String addResReview(ResReview resReview) {
		System.out.println(resReview +"<------");
		resReview.setResReviewPhoto(resReview.getFile().getOriginalFilename());
		if(resReview.getResReviewPhoto()!="") {
			storageService.store(resReview.getFile());
		}
		reviewService.addResReview(resReview);
		return "redirect:/res/resDetail?resNum="+resReview.getResNum();
	}

	@PostMapping("/addSighsReview")
	public String addSightsReview(SightsReview sightsReview) {
		System.out.println(sightsReview +"<------");
		sightsReview.setSightsReviewPhoto(sightsReview.getFile().getOriginalFilename());
		if(sightsReview.getSightsReviewPhoto()!="") {
			storageService.store(sightsReview.getFile());
		}
		reviewService.addSightsReview(sightsReview);
		return "redirect:/sights/detailSights?sightsNum="+sightsReview.getSightsNum();
	}
	
	
	@GetMapping("/deleteSightsReview")
	public  String deleteSightsReview(@RequestParam(name ="sightsReviewNum") String sightsReviewNum,
									  @RequestParam(name ="sightsNum") String sightsNum) {
		System.out.println(sightsNum);
		System.out.println(sightsReviewNum);
		reviewService.deleteSightsReview(sightsReviewNum);

		return "redirect:/sights/detailSights?sightsNum="+sightsNum;
	}
	
	@GetMapping("/deleteResReview")
	public  String deleteResReview(@RequestParam(name ="resReviewNum") String resReviewNum,
									  @RequestParam(name ="resNum") String resNum) {
		
		System.out.println(resReviewNum+"<pppss");
		reviewService.deleteResReview(resReviewNum);

		return "redirect:/res/resDetail?resNum="+resNum;
	}
}
