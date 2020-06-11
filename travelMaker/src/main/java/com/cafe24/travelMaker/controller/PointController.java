package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {
	
	//포인트 관리
	@GetMapping("/pointList")
	public String pointList() {
		
		return "point/pointList";
	}
	
	//포인트 사용내역
	@GetMapping("/pointUse")
	public String pointUse() {
		
		return "point/pointUse";
	}
	
	
}
