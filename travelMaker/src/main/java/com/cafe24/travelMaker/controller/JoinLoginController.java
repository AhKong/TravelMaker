package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinLoginController {
/*
 * 
 * 1.권한별 로그인 
 *  
 * 2.권한별 회원가입
 * 
 * 3.권한별 아이디/비밀번호 찾기 
 * */
	
	@GetMapping("/login")
	public String login() {
		return "join_login/login";
	}
	
	@PostMapping("/loginMember")	
	public String loginMember() {
		return null;
	}
	
	@GetMapping("/addMember")
	public String addMember() {
		return "join_login/addMember";
	}
	@GetMapping("/addAffiliate")
	public String addAffiliate() {
		return "/join_login/addAffiliate";
	}
	
	@GetMapping("/checkMemberLevel")
	public String checkMemberLevel() {
		return "/join_login/checkMemberLevel.html";
	}
}
