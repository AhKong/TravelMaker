package com.cafe24.travelMaker.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cafe24.travelMaker.domain.Message;
import com.cafe24.travelMaker.domain.Notice;
import com.cafe24.travelMaker.service.MsgService;

@Controller
@RequestMapping("/msg")
public class MsgController {
	@Autowired private MsgService msgService;
	@GetMapping("/receivedMsgList")
	public String receivedMsgList(HttpSession session,Model model) {
		String mId= (String)session.getAttribute("SID");
		model.addAttribute("receivedMsgList",msgService.receivedMsgList(mId));

		return "/message/receivedMsgList";
	}
	
	@GetMapping("/sendMsgList")
	public String sendMsgList(HttpSession session, Model model) {
		String mId= (String)session.getAttribute("SID");
		model.addAttribute("sendMsgList",msgService.sendMsgList(mId));

		return "/message/sendMsgList";
	}
	
	@GetMapping("/deleteMsgList")
	public String deleteMsgList(Model model,HttpSession session){
		String mId= (String)session.getAttribute("SID");
		model.addAttribute("deleteMsgList",msgService.deleteMsgList(mId));
	
		return "/message/deleteMsgList";
	}
	
	@GetMapping("/detailMsg")
	public String detailMsg(Model model,@RequestParam(name="massageNum") String massageNum) {
		System.out.println( massageNum+"<---massageNum");
		model.addAttribute("msg",msgService.getDetailMsg(massageNum));
		return "/message/detailMsg";
	}
	
	@PostMapping("/sendMsg")
	public String sendMsg(Message msg) {
		System.out.println(msg);
		msgService.sendMsg(msg);
		return "redirect:/msg/receivedMsgList";
	}
	
	@PostMapping("/deleteMsg")
	@ResponseBody 
	public HashMap<String,String> deleteMsg(@RequestParam(name="checkList[]") String[] checkList){
		HashMap<String,String> result = new HashMap<String,String>();
		System.out.println(checkList.length +"<----zzz");
		result.put("test", "hihi");
		msgService.deleteMsgs(checkList);
		return result;
	}
	
	@GetMapping("/deleteMsg")
	public String deleteMsg(@RequestParam(name="messageNum") String messageNum) {
		msgService.deleteMsg(messageNum);
		return "redirect:/msg/deleteMsgList";
	}
	
	@GetMapping("/notifyDetail")
	public String NoticeList(Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("SID");
		List<Notice> NoticeList = msgService.NoticeList(loginId);
		model.addAttribute("NoticeList", NoticeList);
		return "/message/notifyDetail";
	}
	
	@GetMapping("/noticeCheckUpdate")
	public String noticeCheckUpdate(
		@RequestParam(name = "nCode", required = false) String nCode) {
			System.out.println(nCode+"<----nCode");
			msgService.noticeCheckUpdate(nCode);
			return "redirect:/msg/notifyDetail";
		}
}
