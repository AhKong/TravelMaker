package com.cafe24.travelMaker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.Follow;
import com.cafe24.travelMaker.service.FollowService;

@Controller
@RequestMapping("/follow")
public class FollowController {
	@Autowired private FollowService followService;
	
	@GetMapping("/followers")
	public String followers(Model model, @RequestParam(name="followers", required=false) String followers){
		List<Follow> followList = followService.followers(followers);
		model.addAttribute("followList", followList);
		return "member/followers";
	}  
	
	@GetMapping("/following")
	public String following(Model model, @RequestParam(name="following", required=false) String following){
		List<Follow> followList = followService.following(following);
		model.addAttribute("followList", followList);
		return "member/following";
	}
}
