package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoTripController {

	
	@GetMapping("/addTripMemo")
	public String addTripMemo() {
		
		return "tripMemo/addTripMemo";
	}
	
	@GetMapping("/tripMemoList")
	public String tripMemoList() {
		
		return "tripMemo/tripMemoList";
	}
	
}
