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

	private  @Autowired JoinLoginService joinLoginServcie;
	private @Autowired StorageService storageService;
	private @Autowired  MailService mailService;
	private @Autowired  CertSerivce certService;
	private @Autowired PointSerivce pointService;
	public @Autowired MemberService memberService;

	
	@GetMapping("/login")
	public String login() {
		return "join_login/login";
	}
	
	@RequestMapping("/findId")
	@ResponseBody
	public HashMap<String,String> findId(Member member) {
			HashMap<String,String> getId = new HashMap<String,String>();
			if(!"".equals(member.getmName())  && !"".equals(member.getmTel()) && !"".equals(member.getmEmail())) {
				System.out.println("아이디 찾기");
				System.out.println(member.getmName());
				System.out.println(member.getmTel());
				System.out.println(member.getmEmail());
				Member result = memberService.findId(member);
				//System.out.println(result.getmId() +"<----------- 찾은 아이디");
				//아이디 찾기 입력 정보가 다르면 메일에 "입력 정보가 일치하지 않습니다."
				//메일 추가		
			
				if(result!=null) {
					getId.put("result", result.getmId());
				}else {
					getId.put("result", "none");
				}
			} 
			
			return getId;
	}
	
	@RequestMapping("/findPw")
	public String findPw(Member member) {
		if(!"".equals(member.getmId())  && !"".equals(member.getmTel()) && !"".equals(member.getmEmail())) {
			//비밀번호 찾기 메일
			System.out.println("비밀번호 찾기");
			System.out.println(member.getmId());
			System.out.println(member.getmTel());
			System.out.println(member.getmEmail());
			Member result = memberService.findPw(member);
			System.out.println(result.getmPw() + "<------------ 찾은 비밀번호");
			
		
			//비번 찾기 
		}
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
