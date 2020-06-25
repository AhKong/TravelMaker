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

import com.cafe24.travelMaker.domain.Affiliate;
import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.JoinLoginService;

import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.StorageService;
import com.cafe24.travelMaker.service.PointSerivce;

import com.cafe24.travelMaker.service.MemberService;


@Controller

public class JoinLoginController {	

	@Autowired private JoinLoginService joinLoginServcie;
	@Autowired private StorageService storageService;
	@Autowired private  MailService mailService;
	@Autowired private  CertSerivce certService;
	@Autowired private PointSerivce pointService;

	@GetMapping("/login")
	public String login() {
		return "join_login/login";
	}
	
	@PostMapping("/loginMember")	
	public String loginMember(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		if(member.getmId() != null &&  member.getmPw() != null && !"".equals(member.getmPw()) &&  !"".equals(member.getmId())) {
			Member result = joinLoginServcie.memberLogin(member.getmId());
			if(result !=null) {
				if(member.getmPw().equals(result.getmPw())) {
					session.setAttribute("SID", result.getmId());
		    		session.setAttribute("SLEVEL",result.getmLevel());
		    		session.setAttribute("SNAME", result.getmName());	
		    		System.out.println(session.getAttribute("SID"));
		    		System.out.println(session.getAttribute("SLEVEL"));
		    		System.out.println(session.getAttribute("SNAME"));
		    		System.out.println(pointService.isMyPoint(member.getmId())+"<----내 포인트 ");
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
		int result = joinLoginServcie.addMember(member);
		if(result >0) {// 회원가입 성공
 			System.out.println(result +"<----ryesult");
 			pointService.setSavePointForJoin(member.getmId());
 			int pointAddResult = pointService.savePoint();
 			System.out.println(pointAddResult+"<----point 적립 성공!");
 			int pointResult = pointService.setPoint();
 			System.out.println(pointResult+"<----point insert 성공!");
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
		HashMap<String, Object> certEmail = certService.certEmail(email); // 보낼 메일 생성, 랜덤코드 생성 
		mailService.sendMail((Mail)certEmail.get("mail"));//메일 보내기 
		certEmailResult.put("randomCode", (String)certEmail.get("randomCode"));
		return certEmailResult;
	}
	
	@GetMapping("/addAffiliate")
	public String addAffiliate() {
		return "/join_login/addAffiliate";
	}
	
	@PostMapping("/addAffiliate")
	public String addAffiliate(Affiliate aff) {
		System.out.println(aff +"<----aff");
		joinLoginServcie.addAffiliate(aff);
		return "redirect:/login";
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
