package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.service.MyTripService;


@Controller
@RequestMapping("/myTrip")
public class TripPlanController {
	
	@Autowired private MyTripService myTripService;
	
	@GetMapping("/tripList")
	public String sightsList(Model model,HttpSession session) {// 여행 계획 리스트
		String loginId = (String)session.getAttribute("SID");
		System.out.println(loginId);
		List<MyTrip> tripList = myTripService.sightsList(loginId);
		List<MyTrip> openList = myTripService.openList(loginId);
		List<MyTrip> closeList = myTripService.closeList(loginId);
		System.out.println(tripList +"<-----");
		model.addAttribute("myTripList", tripList);
		model.addAttribute("openList", openList);
		model.addAttribute("closeList", closeList);
		return "/tripPlan/tripList";
		
	}
	
	@GetMapping("/editTrip")
	public String sightsAdd() {// 여행수정..
		return "/tripPlan/editTrip";
	}
	
}
