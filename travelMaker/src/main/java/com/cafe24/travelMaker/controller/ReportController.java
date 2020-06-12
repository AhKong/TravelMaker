package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
	@GetMapping("/manageResReviewReport")
	public String manageResReviewReport() {
		return "/report/manageResReviewReport";
	}
	
	@GetMapping("/manageSightsReviewReport")
	public String manageSightsReviewReport() {
		return "/report/manageSightsReviewReport";
	}
	
}
