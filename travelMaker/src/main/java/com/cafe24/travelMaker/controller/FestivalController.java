package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cafe24.travelMaker.service.FestivalService;
import com.cafe24.travelMaker.domain.Festival;


@Controller
public class FestivalController {

@Autowired FestivalService festivalservice;
	


	@PostMapping("/addFestival")
	public String addFestival(Festival festival) {
		int result = festivalservice.addFestival(festival);
		System.out.println("addFestival result: "+result);
		
		return "index";
	}
	
	
	@GetMapping("/festivalList")
	public String Festival() {
		
		return "festival/festivalList";
	}
	
	
}
