package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {
	@GetMapping("/receivedMsgList")
	public String receivedMsgList() {
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
	public String detailMsg() {
		return "/message/detailMsg";
	}
	@GetMapping("/notifyDetail")
	public String notifyDetail() {
		return "/message/notifyDetail";
	}
}
