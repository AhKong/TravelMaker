package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.ResReview;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@PostMapping("/addResReview")
	public String addResReview(ResReview resReview ) {
		System.out.println(resReview +"<------");
		return "redirect:/";
	}
	
}
