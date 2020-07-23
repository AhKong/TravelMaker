package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.service.IndexTop3Service;

@Controller
public class MainController {

	@Autowired private IndexTop3Service indexTop3Service;
	
	@GetMapping("/")
	public String main(Model model){	
		indexTop3Service.indexTop3();
		System.out.println(indexTop3Service.indexTop3()+"indexxxxxxxxxxxxxxx");
		model.addAttribute("indexTop3", indexTop3Service.indexTop3());
		return "index";
	}
	

}
