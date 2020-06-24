package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.domain.Member;

@Controller
@RequestMapping("/member")
public class MemberController{
	
	
	@GetMapping("/myPage")
	public String myPage() {
		return "/member/myPage";
	}
	
	//아이디 찾기
	@GetMapping("/memberFindId") 
	public String memberFindId(Member member) {
		 
		return "/member/memberFindId";
	}
	
	//비밀번호 찾기
	@GetMapping("/memberFindPw")
	public String memberFindPw(Member member) {
		
		return "/member/memberFindPw";
	}
	
	//탈퇴회원 관리
	@PostMapping("/deleteMember")
	public String deleteMember(Member member) {
		
		return "member/myPage";
	}
	
	//탈퇴회원 관리
	@GetMapping("/deleteMember")
	public String deleteMember(Model model) {
		
		return "member/deleteMember";
	}
	
	//회원정보수정
	@PostMapping("/updateMember")
	public String updateMember(Member member) {
		
		return "member/myPage";
	}
	
	//회원정보 수정
	@GetMapping("/updateMember")
	public String updateMember(Model model) {
		
		return "member/updateMember";
	}
	
	//휴면회원 관리
	@GetMapping("/dormantMember")
	public String dormantMember() {
		
		return "member/dormantMember";
	}
	
	
	
	
}
