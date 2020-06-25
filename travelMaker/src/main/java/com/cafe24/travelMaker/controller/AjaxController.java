package com.cafe24.travelMaker.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.MemberService;

/*ajax 컨트롤러*/
@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired private  MailService mailService;
	@Autowired private  CertSerivce certService;
	@Autowired private  MemberService memberService;
	
	@GetMapping("/certEmail")
	@ResponseBody
	public HashMap<String,String> certEmail(@RequestParam(name="email" ) String email){
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
	
   /*
    * 아이디 중복검사
    * */
	@PostMapping("/idCheck")
	public @ResponseBody HashMap<String,String> idCheck(@RequestParam(name="mId") String mId ){
		System.out.println(mId);
		
		HashMap<String, String> idCheckResult = new HashMap<String,String>();

		if(memberService.mIdCheck(mId)==0) {
			idCheckResult.put("result", "N");
		} else {
			idCheckResult.put("result", "Y");
		}
		return idCheckResult;
	}

}
