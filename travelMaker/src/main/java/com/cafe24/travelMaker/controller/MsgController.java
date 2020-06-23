package com.cafe24.travelMaker.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.Message;
import com.cafe24.travelMaker.service.MsgService;

@Controller
public class MsgController {
	@Autowired private MsgService msgService;
	@GetMapping("/receivedMsgList")
	public String receivedMsgList(HttpSession session,Model model) {
		model.addAttribute("receivedMsgList",msgService.receivedMsgList((String)session.getAttribute("SID")));
		return "/message/receivedMsgList";
	}
	
	@GetMapping("/sendMsgList")
	public String sendMsgList() {
		return "/message/sendMsgList";
	}
	
	@GetMapping("/deleteMsgList")
	public String deleteMsgList(){
		return "/message/deleteMsgList";
	}
	
	@GetMapping("/detailMsg")
	public String detailMsg(Model model,@RequestParam(name="massageNum") String massageNum) {
		System.out.println( massageNum+"<---massageNum");
		model.addAttribute("msg",msgService.getDetailMsg(massageNum));
		return "/message/detailMsg";
	}
	@GetMapping("/notifyDetail")
	public String notifyDetail() {
		return "/message/notifyDetail";
	}
	
	@PostMapping("/sendMsg")
	public String sendMsg(Message msg) {
		System.out.println(msg);
		msgService.sendMsg(msg);
		return "redirect:/receivedMsgList";
	}
	
	
}
