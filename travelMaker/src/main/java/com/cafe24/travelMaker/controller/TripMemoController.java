package com.cafe24.travelMaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.TripMemo;
import com.cafe24.travelMaker.service.TripMemoService;

@Controller
@RequestMapping("/tripMemo")
public class TripMemoController {

	@Autowired TripMemoService tripMemoService;
	
	//내여행기록 리스트(메인화면)
	@GetMapping("/tripMemo")
	public String tripMemoList(Model model) {
		System.out.println("tripMemoList TripMemoController 도착");
		List<TripMemo> memoList = tripMemoService.tripMemoList();
		model.addAttribute("memoList", memoList);
		
		return "tripMemo/tripMemo";
	}
	
	//내여행기록 등록
	@PostMapping("/addTripMemo")
	public String addTripMemo(TripMemo tripMemo) {
		System.out.println("addTripMemo TripMemoController 도착");
		System.out.println(tripMemo.getmId()+" <- tripMemo.getmId()");
		int result = tripMemoService.addTripMemo(tripMemo);
		
		return "redirect:/tripMemo/tripMemo";
	}
	
	
	
}
