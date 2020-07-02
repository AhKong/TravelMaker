package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//관리자페이지 - 회원들의 포인트 사용내역
	@GetMapping("/pointUseAdminList")
	public String pointUseAdminList(Model model) { 
		System.out.println("pointUseAdminList PointController 도착");
		List<Point> pointUseAdminList = pointService.pointUseAdminList();
		model.addAttribute("pointUseAdminList", pointUseAdminList);
		
		return "point/pointUseAdminList";
	}
	
	//관리자페이지 - 회원들의 포인트 적립내역
	@GetMapping("/pointSaveAdminList")
	public String pointSaveAdminList(Model model) { 
		System.out.println("pointSaveAdminList PointController 도착");
		List<Point> pointSaveAdminList = pointService.pointSaveAdminList();
		model.addAttribute("pointSaveAdminList", pointSaveAdminList);
		
		return "point/pointSaveAdminList";
	}

}
