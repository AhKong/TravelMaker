package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.travelMaker.service.MailService;


@Controller 
public class MainController {
	@Autowired public MailService mailService;
	@GetMapping("/sendEmail")
	public String index(){
		mailService.sendSimpleMessage("129212@naver.com", "이미봤기때문에", "어쩔수없음");
		return "redirect:/";
	}
	@GetMapping("/")
	public String main(){
		return "/index";
	}

}
