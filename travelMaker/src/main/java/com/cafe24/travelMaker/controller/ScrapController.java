package com.cafe24.travelMaker.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.ResScrap;
import com.cafe24.travelMaker.domain.SightsScrap;

@Controller
public class ScrapController {
	
	@RequestMapping("/SightsScrap") // 관광지 스크랩
	public SightsScrap SightsScrap(@RequestParam("mId") Model model, HttpServletResponse response) throws IOException {
		if(!"".equals("")) { // 로그인한 세션id값???
			if("".equals("")) { // 로그인한 세션id값???
				//insert
			}else {
				//delete
			}
		} else {
			//java alert
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요한 기능 입니다.');</script>");
			out.flush(); 
		}
			
		return null;
	}
	@GetMapping("/resScrap") // 음식점 스크랩
	public ResScrap resScrap() {
		
		return null;
	}
}
