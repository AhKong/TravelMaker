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
		System.out.println(result+" <- result addFestival FestivalController");
		return "redirect:/festivalList";
	}
	
	//축제 수정 화면으로 이동 
	@GetMapping("/updateFestival")
	public String festivalSelect(Model model, @RequestParam(name="fesNum", required=false) String fesNum) {
		
		System.out.println(fesNum+" <- fesNum festivalSelect FestivalController");
		Festival festival = festivalService.festivalSelect(fesNum);	
		System.out.println(festival+" <- festival festivalSelect FestivalController");
		model.addAttribute("festival", festival);
		
		return "festival/updateFestival";
	}
	
	//축제 수정하기 
	@PostMapping("/updateFestival")
	public String updateFestival(Festival festival) {
		System.out.println("updateFestival FestivalController 도착");
		int result = festivalService.updateFestival(festival);
		System.out.println(festival+" <- festival updateFestival FestivalController");
		System.out.println(festival.getFesNum()+" <- getFesNum updateFestival FestivalController");
		System.out.println(result+" <- result updateFestival FestivalController");
		
		return "redirect:/festivalList";
	}
	
	//축제 리스트
	@GetMapping("/festivalList")
	public String getFestivalList(Model model){
		System.out.println("getFestivalList FestivalController 도착");
		List<Festival> getFestivalList = festivalService.getFestivalList();
		System.out.println(getFestivalList+" <- getFestivalList getFestivalList FestivalController");
		model.addAttribute("getFestivalList", getFestivalList);
		
		return "festival/festivalList";
	}
	
	//축제 삭제
	@GetMapping("/deleteFestival")
	public String deleteFestival(Model model, @RequestParam(name="fes_num", required=false) String fesNum) {
		System.out.println("deleteFestival FestivalController 도착");
		System.out.println(fesNum+" <- fesNum deleteFestival FestivalController");
		int result = festivalService.deleteFestival(fesNum);
		System.out.println(result+" <- result deleteFestival FestivalController");
		
		return "redirect:/festivalList";
	}
	
}
