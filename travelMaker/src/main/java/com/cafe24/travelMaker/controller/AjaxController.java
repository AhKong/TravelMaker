package com.cafe24.travelMaker.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.domain.Message;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.MemberService;
import com.cafe24.travelMaker.service.MsgService;

/*ajax 컨트롤러*/
@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired private  MailService mailService;
	@Autowired private  CertSerivce certService;
	@Autowired private MemberService memberService;
	@Autowired private MsgService msgService;

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
	
	@GetMapping("/unReadMsgList")	
	public @ResponseBody HashMap<String,List<Message>> unReadMsgList(HttpSession session){
	
		HashMap<String,List<Message>> unReadMsgList = new HashMap<String,List<Message>>();
		String targetId = (String) session.getAttribute("SID");
		System.out.println(msgService.unReadMsgList(targetId));
		unReadMsgList.put("result", msgService.unReadMsgList(targetId));
		return unReadMsgList;
	}
	

}
