package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.service.MyTripService;
import com.cafe24.travelMaker.service.TripPlanService;


@Controller
@RequestMapping("/myTrip")
public class TripPlanController {
	
	@Autowired private MyTripService myTripService;
	@Autowired private TripPlanService tripPlanService;
	@GetMapping("/tripList")
	public String sightsList(Model model,HttpSession session) {// 여행 계획 리스트
		String loginId = (String)session.getAttribute("SID");
		System.out.println(loginId);
		List<MyTrip> tripList = myTripService.sightsList(loginId);
		List<MyTrip> openList = myTripService.openList(loginId);
		List<MyTrip> closeList = myTripService.hideList(loginId);
		List<MyTrip> scrapList = myTripService.scrapList(loginId);
		System.out.println(tripList +"<-----");
		model.addAttribute("myTripList", tripList);
		model.addAttribute("openList", openList);
		model.addAttribute("closeList", closeList);
		model.addAttribute("scrapList", scrapList);
		
		return "/tripPlan/tripList";
		
	}
	
	@PostMapping("/editTrip")
	public String sightsAdd(Model model, @RequestParam(name="tripName", required=false) String tripName
										,@RequestParam(name="jb-radio", required=false) String openCheck
										,HttpSession session) {// 여행수정..
		String loginId = (String)session.getAttribute("SID");
		System.out.println(tripName+" <<<<<<<<<<<tripName");
		model.addAttribute("tripName", tripName);
		System.out.println(openCheck+" <<<<<<<<<<openCheck");
		model.addAttribute("openCheck", openCheck);
		
		MyTrip myTrip = new MyTrip();
		myTrip.setmId(loginId);
		myTrip.setoCheck(openCheck);
		myTrip.settName(tripName);
		System.out.println(myTrip+" <<<<<<<<<<myTrip");
		int TripNameInsert = tripPlanService.TripNameInsert(myTrip);
		
		return "/tripPlan/editTrip";
	}
	
}
