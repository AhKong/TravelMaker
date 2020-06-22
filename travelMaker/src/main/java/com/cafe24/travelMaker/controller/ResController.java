package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.travelMaker.service.ResService;
import com.cafe24.travelMaker.service.SightsService;

@Controller
public class ResController {
	@Autowired private ResService resService;
	@Autowired private SightsService sightsService;
	
	@GetMapping("/resList")
	public String resList() {
		return "/res/resList";
	}
	
	@GetMapping("/addRes")
	public String addRes(Model model) {
		model.addAttribute("resList", resService.selectResCate());
		model.addAttribute("doList",sightsService.selectDo());
		return "/res/addRes";
	}
	
	@GetMapping("/updateRes")
	public String udpateRes() {
		return "/res/updateRes";
	}
	
	@GetMapping("/deleteRes") 
	public String deleteRes() {
		return "res/deleteRes";
	}
	
	@GetMapping("/detailRes")
	
	public String detailRes() {
		return "res/detailRes";
	}
	
	@GetMapping("/moreResPhoto")
	public String moreResPhoto() {
		return "res/morePhotos";
	}
	
	
}
