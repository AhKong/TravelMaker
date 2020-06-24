package com.cafe24.travelMaker.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController{
	@Autowired MemberService memberService;
	
	@GetMapping("/myPage")
	public String myPage() {
		return "/member/myPage";
	}
	
	//아이디 찾기
	@GetMapping("/memberFindId") 
	public String memberFindId(Member member) {
		 
		return "/member/memberFindId";
	}
	
	//아이디 찾기 기능
	@RequestMapping("/findId")
	@ResponseBody
	public HashMap<String,String> findId(Member member) { 
			HashMap<String,String> getId = new HashMap<String,String>();
				System.out.println("아이디 찾기");
				System.out.println(member.getmName());
				System.out.println(member.getmTel());
				System.out.println(member.getmEmail());
				Member result = memberService.findId(member);
				//System.out.println(result.getmId() +"<----------- 찾은 아이디");
	
				System.out.println(result+"<---------- result");
				if(result!=null) {
					getId.put("result", result.getmId());
				}else {
					getId.put("result", "none");
				}
			return getId;
	}
	
	//비밀번호 찾기
	@GetMapping("/memberFindPw")
	public String memberFindPw(Member member) {
		
		return "/member/memberFindPw";
	}
	//비밀번호 찾기 기능
	@RequestMapping("/findPw")
	@ResponseBody
	public HashMap<String, String> findPw(Member member) { 	
		HashMap<String, String> getPw = new HashMap<String, String>();
	
			System.out.println("비밀번호 찾기");
			System.out.println(member.getmId());
			System.out.println(member.getmTel());
			System.out.println(member.getmEmail());
			Member result = memberService.findPw(member);
			//System.out.println(result.getmPw() + "<------------ 찾은 비밀번호");
			
			System.out.println(result+"<---------- result");
			if(result!=null) {
				getPw.put("result", result.getmPw());
			}else {
				getPw.put("result", "none");
			}
		return getPw;
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
