package com.cafe24.travelMaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.service.FestivalService;
import com.cafe24.travelMaker.service.StorageService;
import com.cafe24.travelMaker.domain.Festival;


@Controller
public class FestivalController {

@Autowired FestivalService festivalService;
@Autowired StorageService storageService;
	
	//축제화면으로 이동 
/*	@GetMapping("/festivalList")
	public String Festival(Model model) {
		
		return "festival/festivalList";
	}
*/	
	//축제 등록하기 
	@PostMapping("/addFestival")
	public String addFestival(Festival festival) {
		int result = festivalService.addFestival(festival);
		System.out.println("addFestival result: "+result);
		return "festival/festivalList";
	}
	
	//축제 수정 화면으로 이동 
	@GetMapping("/updateFestival")
	public String festivalSelect(Model model, @RequestParam(name="fesNum", required=false) String fesNum) {
		
		System.out.println("fesNum-->"+fesNum);
		Festival festival = festivalService.festivalSelect(fesNum);	
		System.out.println("controller festival: "+festival);
		model.addAttribute("festival", festival);
		
		return "festival/updateFestival";
	}
	
	//축제 수정하기 
	@PostMapping("/updateFestival")
	public String updateFestival(Festival festival) {
		festivalService.updateFestival(festival);
		
		return "redirect:/festivalList";
	}
	
	//축제 리스트
	@GetMapping("/festivalList")
	public String gettFestivalList(Model model){
		List<Festival> getFestivalList = festivalService.getFestivalList();
		System.out.println("getFestivalList :"+ getFestivalList);
		model.addAttribute("getFestivalList", getFestivalList);
		
		return "festival/festivalList";
	}
	
}
