package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SightsController{
	@GetMapping("/sightsList")
	
	public String sightsList() {
		return "/sights/sightsList";
	}
	
	@GetMapping ("/addSights")
	public String addSights() {
		return "/sights/addSights";
	}
	
	@GetMapping("/updateSights")
	public String updateSights() {
		return "/sights/updateSights";
	}
}
