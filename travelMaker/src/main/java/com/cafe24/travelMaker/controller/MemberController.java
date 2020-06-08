package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController{
	@GetMapping("/myPage")
	public String myPage() {
		return "/member/myPage";
	}
}
