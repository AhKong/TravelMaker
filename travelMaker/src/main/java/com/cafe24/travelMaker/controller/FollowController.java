package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/follow")
public class FollowController {
	@GetMapping("/followers")
	public String follow(){
		return "member/followers";
	}  
	
	@GetMapping("/following")
	public String following(){
		return "member/following";
	}
}
