package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.service.FestivalService;
import com.cafe24.travelMaker.domain.Festival;


@Controller
public class FestivalController {

@Autowired FestivalService festivalservice;
	
	//축제화면으로 이동
	@GetMapping("/festivalList")
	public String Festival() {
		
		return "festival/festivalList";
	}
	
	//축제 등록하기 
	@PostMapping("/addFestival")
	public String addFestival(Festival festival) {
		int result = festivalservice.addFestival(festival);
		System.out.println("addFestival result: "+result);
		
		return "festival/festivalList";
	}
	
	//축제 수정 화면으로 이동
	@GetMapping("/festivalSelect")
	public String festivalSelect(Model model, @RequestParam(name="fes_num", required=false) String fesNum) {
		
		
		return "redirect:festival/updateFestival";
	}
	
	//축제 수정하기
	@PostMapping("/updateFestival")
	public String updateFestival(Festival festival) {
		
		
		return "festival/updateFestival";
	}
	
	
}
