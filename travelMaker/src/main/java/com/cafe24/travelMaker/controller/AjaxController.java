package com.cafe24.travelMaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.travelMaker.domain.SightsScrap;
import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.domain.ResScrap;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.MemberService;
import com.cafe24.travelMaker.service.ScrapSightsService;

/*ajax 컨트롤러*/
@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired private  MailService mailService;
	@Autowired private  CertSerivce certService;
	@Autowired private MemberService memberService;
	@Autowired private  ScrapSightsService scrapsightsservice;

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
	

	// 관광지 스크랩
	@RequestMapping(value = "/SightsScrap") 
	@ResponseBody
	public HashMap<String, String> SightsScrap(@RequestParam(value="mId") String mId,
											@RequestParam(value="sights") String sights, 
			SightsScrap sightsScrap, HttpServletResponse response, HttpSession session) throws IOException {
		
		HashMap<String, String> scrap = new HashMap<String, String>();
		System.out.println("/SightsScrap 요청 호출 " + mId);
		//String sights1 = sights;
		//System.out.println(sights1);
		SightsScrap scrapselect = scrapsightsservice.sSelect(sightsScrap);
		System.out.println(scrapselect+"<---------- sSelect");

		if(scrapselect !=null) { // 내가 해당 관광명소에 대해 스크랩이 되어있음
			scrap.put("mid", scrapselect.getmId());
			scrap.put("sightsNum", scrapselect.getSightsNum());
			scrap.put("tripNum", scrapselect.gettNum());
			scrap.put("sNum", scrapselect.getSsNum());
			// 딜리트
			System.out.println(scrap+"<--------------- 해쉬맵ㅂ");
			System.out.println(scrapselect.getSightsNum() + "<<<<<<<<<<<< 여행번호");
		} else {
			scrapsightsservice.sInsertScrap(sightsScrap);
			//인설트
		}
		
		
		return scrap;
	}
	
	// 음식점 스크랩
	@GetMapping("/resScrap") 
	public ResScrap resScrap() {
		
		return null;
	}

}
