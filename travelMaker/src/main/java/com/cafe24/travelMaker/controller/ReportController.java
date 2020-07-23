package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.ReviewReport;
import com.cafe24.travelMaker.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired private ReportService reportService;
	@GetMapping("/manageResReviewReport")
	public String manageResReviewReport() {
		return "/report/manageResReviewReport";
	}
	
	@GetMapping("/manageSightsReviewReport")
	public String manageSightsReviewReport() {
		return "/report/manageSightsReviewReport";
	}
	
	@PostMapping("/sightsReveiw")
	public String addSighstReviewReport(ReviewReport reviewReport) {
		System.out.println("1111111");
		System.out.println(reviewReport +"<-----요ㅕ기여기!!");
		reviewReport.setReviewType("Sights");
		reportService.reportSightsReivew(reviewReport);
		return "redirect:/";
	}
	
}
