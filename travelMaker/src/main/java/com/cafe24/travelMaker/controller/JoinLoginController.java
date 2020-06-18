package com.cafe24.travelMaker.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.JoinLoginService;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.StorageService;

@Controller

public class JoinLoginController {	
	private  @Autowired JoinLoginService joinLoginServcie;
	private @Autowired StorageService storageService;
	private @Autowired  MailService mailService;
	private @Autowired  CertSerivce certService;
	@GetMapping("/login")
	public String login() {
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
			//redirect 할 때 값 유지할 수 있도록 해주는것!!! 
			redirectAttr.addAttribute("message","등록된 정보가 없습니다.");
		}
		return "redirect:/login";
	}
	
	@GetMapping("/addMember")
	public String addMember() {
		
		return "join_login/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		//System.out.println(result +"<----result");

		member.setmAvatar(member.getFile().getOriginalFilename());
		if(!"".equals(member.getmAvatar())) {
			storageService.store(member.getFile());
		}
		return "redirect:/login";
	}
	
	@GetMapping("/certEmail")
	public @ResponseBody HashMap<String,String> certEmail(@RequestParam(name="email" ) String email){
		/* 이메일 인증 
		 * 
		 * */
		System.out.println("email>>>>"+email);
		HashMap<String, String> certEmailResult = new HashMap<String,String>();
		HashMap<String, Object> certEmail = certService.certEmail(email);
		mailService.sendMail((Mail)certEmail.get("mail"));
		certEmailResult.put("randomCode", (String)certEmail.get("randomCode"));
		return certEmailResult;
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
