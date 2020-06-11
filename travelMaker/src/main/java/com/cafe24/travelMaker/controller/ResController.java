package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResController {
	@GetMapping("/resList")
	public String resList() {
		return "/res/resList";
	}
	
	@GetMapping("/addRes")
	public String addRes() {
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
