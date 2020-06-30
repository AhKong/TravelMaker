package com.cafe24.travelMaker.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.travelMaker.domain.SightsScrap;
import com.cafe24.travelMaker.mapper.ScrapModalMapper;
import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.domain.ResScrap;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.MemberService;
import com.cafe24.travelMaker.service.ScrapSightsService;

/*ajax 컨트롤러*/
@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired private MemberService memberService;
	@Autowired private ScrapSightsService scrapsightsservice;
	@Autowired private ScrapModalMapper scrapModalMapper;


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
		
	// 관광지 스크랩
	@RequestMapping(value = "/SightsScrap") 
	@ResponseBody
	public SightsScrap SightsScrap(@RequestParam(name="mId") String mId,
									@RequestParam(name="sightsNum") String sightsNum,
			SightsScrap sightsScrap, HttpServletResponse response, HttpSession session) throws IOException {
		
		SightsScrap scrapselect = scrapsightsservice.sSelect(sightsScrap);
		System.out.println("/SightsScrap 요청 호출 " + mId);
		System.out.println(scrapselect+"<---------- sSelect 컨트롤러컨트롤러컨트롤러컨트롤러컨트롤러컨트롤러컨트롤러컨트롤러컨트롤러컨트롤러");

		if(scrapselect !=null) { // 내가 해당 관광명소에 대해 스크랩이 되어있음
			System.out.println(scrapselect.getSightsNum() + "<<<<<<<<<<<< 여행번호");
			scrapsightsservice.sDeleteScrap(sightsScrap);
			System.out.println("delete");
		} else {
			scrapsightsservice.sInsertScrap(sightsScrap);
			System.out.println("insert");
			//인설트
		}
		
		
		return scrapselect;
	}
	
	// 음식점 스크랩
	@GetMapping("/resScrap") 
	public ResScrap resScrap() {
		
		return null;
	}

	@RequestMapping("/scrapModal")
	@ResponseBody
	public  HashMap<String,List<MyTrip>> ScrapModal(HttpSession session, @RequestParam(name="mId")String mId) {
		System.out.println(mId);
		String loginId = (String) session.getAttribute("SID");
		System.out.println(loginId);
		HashMap<String,List<MyTrip>> result = new HashMap<String,List<MyTrip>>();
		result.put("result",scrapModalMapper.ModalScarpList(loginId));
		System.out.println(scrapModalMapper.ModalScarpList(loginId));
		return result;
	}
}
