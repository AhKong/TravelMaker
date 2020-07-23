package com.cafe24.travelMaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import com.cafe24.travelMaker.domain.TripPlan;
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
		System.out.println(myTrip+" <<<<<<<<<< POSTeditTrip - myTrip");
		int TripNameInsert = tripPlanService.TripNameInsert(myTrip);
		System.out.println(TripNameInsert + "<< tripnameinsertttttttttttttt");
		return "/tripPlan/editTrip";
	}
	
	@GetMapping("/editTrip")
	public String sightsEdit(Model model,HttpSession session,
									@RequestParam(name="tNum", required = false) String tNum,
									@RequestParam(name="tName", required = false) String tName) {
		String loginId = (String)session.getAttribute("SID");
		String myTripNum = tripPlanService.myTripNum(tNum);
		System.out.println(myTripNum+" GETeditTrip- myTripNum");
		model.addAttribute("tripName", tName);
		
		List<TripPlan> selectTripPlan = tripPlanService.selectTripPlan(loginId, tNum);
		System.out.println(selectTripPlan + " <<<< 셀렉ㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌselectTripPlan");		
		model.addAttribute("selectTripPlan", selectTripPlan);	
		
		
		List<TripPlan> sTripPlan = tripPlanService.sTripPlan();
		model.addAttribute("sTripPlan", sTripPlan);
		return "/tripPlan/editTrip";
	}
	
	@GetMapping("/deleteTripPlan")
	public String deleteTripPlan(HttpSession session,MyTrip myTrip, HttpServletResponse response,
									@RequestParam(name="tNum", required = false) String tNum,
									@RequestParam(name="mId", required = false) String mId) throws IOException {
		String loginId = (String) session.getAttribute("SID");
		String insertId = tripPlanService.sTripMid(mId);
		System.out.println(insertId+"<<<<<<<<< select mIdd");
		
		if(loginId == insertId) { 
			int dTripPlan = tripPlanService.deleteTripPlan(loginId, tNum);
			System.out.println(dTripPlan+"<<<<<<<<<<<<<<<<<<<<<<<< 삭제성공ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
		}else {
			
			  response.setContentType("text/html; charset=UTF-8"); PrintWriter out =  response.getWriter();
			  out.println("<script>alert('여행계획 삭제는 생성한 사람만 가능합니다.');</script>");
			  out.flush();
		}
		

		return "/myTrip/tripList";
	}
	
}
