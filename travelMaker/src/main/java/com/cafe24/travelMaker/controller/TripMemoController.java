package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tripMemo")
public class TripMemoController {

	
	@GetMapping("/tripMemo")
	public String tripMemoList() {
		
		return "tripMemo/tripMemo";
	}
	
}
