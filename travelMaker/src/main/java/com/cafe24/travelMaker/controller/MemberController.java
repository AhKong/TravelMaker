package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController{
	@GetMapping("/myPage")
	public String myPage() {
		return "/member/myPage";
	}
	
	@GetMapping("/memberFindId") 
	public String memberFindId() {
		
		return "/member/memberFindId";
	}
	
	@GetMapping("/confirmId")
	public String confirmId() {
		
		return "/member/confirmId";
	}
	
	@PostMapping("memberFindPw")
	public String memberFindPw() {
		
		return "/member/memberFindPw";
	}
}
