package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.Point;
import com.cafe24.travelMaker.service.PointService;

@Controller
@RequestMapping("/point")
public class PointController {
	@Autowired PointService pointService;
	
	//마이페이지 - 포인트 사용내역
	@GetMapping("/pointUse")
	public String pointUse(Model model, HttpSession session) {
		System.out.println("pointUse PointController 도착");
		String loginId = (String)session.getAttribute("SID");
		List<Point> pointUseList = pointService.pointUseList(loginId);
		List<Point> pointSaveList = pointService.pointSaveList(loginId);
		List<Point> getTotalPoint = pointService.getTotalPoint(loginId);
		model.addAttribute("pointUseList", pointUseList);
		model.addAttribute("pointSaveList", pointSaveList);
		model.addAttribute("getTotalPoint", getTotalPoint);
		
		return "point/pointUse";
	}
	
	//관리자 - 포인트 관리페이지
	@GetMapping("/pointList")
	public String pointUseAdminList(Model model) { 
		System.out.println("pointUseAdminList PointController 도착");
		List<Point> pointUseAdminList = pointService.pointUseAdminList();
		model.addAttribute("pointUseAdminList", pointUseAdminList);
		
		return "point/pointList";
	}
	
}
