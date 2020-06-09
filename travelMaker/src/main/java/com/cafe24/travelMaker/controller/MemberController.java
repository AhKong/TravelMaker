package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.travelMaker.domain.Member;

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
	

	@PostMapping("/deleteMember")
	public String deleteMember(Member member) {
		System.out.println("<post> deleteMember 컨트롤러 도착~! 장하다 장해 !!");
		
		return "Member/myPage";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(Model model) {
		// System.out.println("<get> deleteMember 컨트롤러 도착~! 장하다 장해 !!");
		
		return "Member/deleteMember";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(Member member) {
		// System.out.println("<post> updateMember 컨트롤러 도착~! 장하다 장해 !!");
		
		return "Member/myPage";
	}
	
	@GetMapping("/updateMember")
	public String updateMember(Model model) {
		// System.out.println("<get> updateMember 컨트롤러 도착~! 장하다 장해 !!");
		
		return "Member/updateMember";
	}
	
	
	
	
	
}
