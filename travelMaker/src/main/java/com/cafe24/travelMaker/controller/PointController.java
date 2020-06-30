package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.Point;
import com.cafe24.travelMaker.service.PointSerivce;

@Controller
@RequestMapping("/point")
public class PointController {
	@Autowired PointSerivce pointService;
	
	//포인트 관리
	@GetMapping("/pointList")
	public String pointList() {
		
		return "point/pointList";
	}
	
	//포인트 사용내역
	@GetMapping("/pointUse")
	public String pointUse(Model model, HttpSession session) {
		System.out.println("pointUse PointController 도착");
		String loginId = (String)session.getAttribute("SID");
		List<Point> pointUseList = pointService.pointUse(loginId);
		System.out.println(pointUseList+" <- pointUseList");
		model.addAttribute("loginId", loginId);
		model.addAttribute("pointUseList", pointUseList);
		
		return "point/pointUse";
	}
	
	
}
