package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.ResReview;
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
	
}
