package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.Follow;
import com.cafe24.travelMaker.service.FollowService;

@Controller
@RequestMapping("/follow")
public class FollowController {
	@Autowired private FollowService followService;
	
	@GetMapping("/followers")
	public String followers(Model model, HttpSession session){
		String loginId = (String)session.getAttribute("SID");
		List<Follow> followList = followService.followers(loginId);
		model.addAttribute("followList", followList);
		return "member/followers";
	}  
	
	@GetMapping("/following")
	public String following(Model model, HttpSession session){
		String loginId = (String)session.getAttribute("SID");
		List<Follow> followList = followService.following(loginId);
		model.addAttribute("followList", followList);
		return "member/following";
	}
}
