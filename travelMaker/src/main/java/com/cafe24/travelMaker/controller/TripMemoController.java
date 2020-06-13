package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripMemoController {

	
	@GetMapping("/tripMemo")
	public String tripMemoList() {
		
		return "tripMemo/tripMemo";
	}
	
}
