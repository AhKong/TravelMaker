package com.cafe24.travelMaker.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.service.JoinLoginService;
import com.cafe24.travelMaker.service.MemberService;

@Controller

public class JoinLoginController {	
	public @Autowired JoinLoginService joinLoginServcie;
	public @Autowired MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "join_login/login";
	}
	
	@RequestMapping("/findIdPw")
	public String findIdPw(Member member) {
			if(!"".equals(member.getmName())  && !"".equals(member.getmTel()) &&!"".equals(member.getmEmail())) {
				System.out.println("아이디 찾기");
				System.out.println(member.getmName());
				System.out.println(member.getmTel());
				System.out.println(member.getmEmail());
				//아이디 찾기 메일 아이디 찾기 비밀번호 찾기 나눠
			}else if(!"".equals(member.getmId())  && !"".equals(member.getmTel()) &&!"".equals(member.getmEmail())) {
				//비밀번호 찾기 메일
				System.out.println("비밀번호 찾기");
			}
		
		return "join_login/login";
		
	}
	
	@PostMapping("/loginMember")	
	public String loginMember(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		if(member.getmId() != null &&  member.getmPw() != null && !"".equals(member.getmPw()) &&  !"".equals(member.getmId())) {
			Member result =joinLoginServcie.memberLogin(member.getmId());
			if(result !=null) {
				if(member.getmPw().equals(result.getmPw())) {
					session.setAttribute("SID", result.getmId());
		    		session.setAttribute("SLEVEL",result.getmLevel());
		    		session.setAttribute("SNAME", result.getmName());	
		    		System.out.println(session.getAttribute("SID"));
		    		System.out.println(session.getAttribute("SLEVEL"));
		    		System.out.println(session.getAttribute("SNAME"));
		    		return "redirect:/";
				}
			}
			redirectAttr.addAttribute("message","등록된 정보가 없습니다.");
		}
		return "redirect:/login";
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

	@PostMapping("/idCheck")
	public @ResponseBody HashMap<String,String> idCheck(@RequestParam(name="mId") String mId ){
		System.out.println(mId);
		
		HashMap<String, String> idCheckResult = new HashMap<String,String>();

		if(joinLoginServcie.mIdCheck(mId)==0) {
			idCheckResult.put("result", "N");
		} else {
			idCheckResult.put("result", "Y");
		}

		
		return idCheckResult;
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
}
