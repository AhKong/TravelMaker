package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanTripController {

	@GetMapping("/tripList")
	public String sightsList() {
		return "/trip/tripList";
		
	}
	
	@GetMapping("/editTrip")
	public String sightsAdd() {
		return "/trip/editTrip";
	}
}
