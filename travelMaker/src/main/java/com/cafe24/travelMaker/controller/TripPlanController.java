package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripPlanController {
	@GetMapping("/tripList")
	public String sightsList() {// 여행 계획 리스트
		return "/tripPlan/tripList";
		
	}
	
	@GetMapping("/editTrip")
	public String sightsAdd() {// 여행수정..
		return "/tripPlan/editTrip";
	}
}
