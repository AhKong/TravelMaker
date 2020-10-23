package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.travelMaker.service.IndexTop3Service;

@Controller
public class MainController {

	@Autowired private IndexTop3Service indexTop3Service;
	
	@GetMapping("/main")
	public String main(Model model){	

		model.addAttribute("indexTop3", indexTop3Service.indexTop3());
		return "/index";
	}
	
	@GetMapping("/")
	public String mainInfo() {
		return "indexInfo";
	}
}
