package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.TripMemo;
import com.cafe24.travelMaker.domain.TripPlan;
import com.cafe24.travelMaker.service.TripMemoService;

@Controller
@RequestMapping("/tripMemo")
public class TripMemoController {

	@Autowired TripMemoService tripMemoService;
	
	//내여행기록 리스트(메인화면)
	@GetMapping("/tripMemo")
	public String tripMemoList(Model model, String SID, HttpSession session) {
		System.out.println("tripMemoList TripMemoController 도착");
		String mId = (String) session.getAttribute("SID");
		List<TripMemo> memoList = tripMemoService.tripMemoList(mId);
		model.addAttribute("memoList", memoList);
		
		return "tripMemo/tripMemo";
	}
	
	//내여행기록 등록 
	@GetMapping("/addTripMemo")
	public String addTripMemo() {
		return "tripMemo/addTripMemo";
	}
	
	//내여행기록 등록
	@PostMapping("/addTripMemo")
	public String addTripMemo(TripMemo tripMemo, String mId) {
		System.out.println("addTripMemo TripMemoController 도착");
		System.out.println(tripMemo.getmId()+" <- tripMemo.getmId()");
		int result = tripMemoService.addTripMemo(tripMemo);
		List<TripPlan> getTripPlanList = tripMemoService.getTripPlanList(mId);
		
		return "tripMemo/addTripMemo";
	}
	
	//내여행기록 수정
	@GetMapping("/updateTripMemo")
	public String updateTripMemo() {
		return "tripMemo/updateTripMemo";
	}
	
	//내여행기록 수정
	@PostMapping("/updateTripMemo")
	public String updateTripMemo(TripMemo tripMemo, String mId) {
		return "redirect:/tripMemo/tripMemo";
	}
	
	//내여행기록 삭제
	@GetMapping("/deleteTripMemo")
	public String deleteTripMemo() {
		return "tripMemo/tripMemo";
	}
	
}
