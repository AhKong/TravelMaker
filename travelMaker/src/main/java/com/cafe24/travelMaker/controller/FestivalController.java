package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FestivalController {

	
	@GetMapping("/festivalList")
	public String Festival() {
		System.out.println("Festival 컨트롤러 도착~~~~!");
		
		return "festival/festivalList";
	}
	
	
}
