package com.cafe24.travelMaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.service.FestivalService;
import com.cafe24.travelMaker.service.StorageService;
import com.cafe24.travelMaker.domain.Festival;


@Controller()
@RequestMapping("/festival")
public class FestivalController {

@Autowired FestivalService festivalService;
@Autowired StorageService storageService;
	
	
	//축제 등록하기 
	@PostMapping("/addFestival")
	public String addFestival(Festival festival) {
		System.out.println("addFestival FestivalController 도착");
		int result = festivalService.addFestival(festival);
		System.out.println(festival+" <- festival addFestival FestivalController");
		System.out.println(result+" <- result addFestival FestivalController");
		System.out.println(festival.getMember().toString()+" <- festival.getMember().toString() addFestival FestivalController");
		
		return "redirect:/festival/ingFestivalList";
	}
	
	//축제 수정 화면으로 이동 
	@GetMapping("/updateFestival")
	public String festivalSelect(Model model, @RequestParam(name="fesNum", required=false) String fesNum) {
		
		System.out.println(fesNum+" <- fesNum festivalSelect FestivalController");
		Festival festival = festivalService.festivalSelect(fesNum);	
		List<Festival> upList = festivalService.ingFestivalList();
		System.out.println(festival+" <- festival festivalSelect FestivalController");
		System.out.println(upList+" <- upList festivalSelect FestivalController");
		model.addAttribute("festival", festival);
		model.addAttribute("upList", upList);
		
		
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
		
		return "redirect:/festival/ingFestivalList";
	}
	
	//축제 리스트 (현재 진행중)
	@GetMapping("/ingFestivalList")
	public String ingFestivalList(Model model){
		System.out.println("ingFestivalList FestivalController 도착");
		List<Festival> fList = festivalService.ingFestivalList();
		System.out.println(fList+" <- fList ingFestivalList FestivalController");
		model.addAttribute("fList", fList);
		
		return "festival/festivalList";
	}
	
	//축제 리스트 (진행 예정)
	@GetMapping("/preFestivalList")
	public String preFestivalList(Model model){
		System.out.println("preFestivalList FestivalController 도착");
		List<Festival> fList = festivalService.preFestivalList();
		System.out.println(fList+" <- fList preFestivalList FestivalController");
		model.addAttribute("fList", fList);
		
		return "festival/festivalList";
	}
	
	//축제 리스트 (진행 종료)
	@GetMapping("/postFestivalList")
	public String postFestivalList(Model model){
		System.out.println("postFestivalList FestivalController 도착");
		List<Festival> fList = festivalService.postFestivalList();
		System.out.println(fList+" <- fList postFestivalList FestivalController");
		model.addAttribute("fList", fList);
		
		return "festival/festivalList";
	}
	
	
	//축제 삭제
	@GetMapping("/deleteFestival")
	public String deleteFestival(Model model, @RequestParam(name="fes_num", required=false) String fesNum) {
		System.out.println("deleteFestival FestivalController 도착");
		System.out.println(fesNum+" <- fesNum deleteFestival FestivalController");
		int result = festivalService.deleteFestival(fesNum);
		System.out.println(result+" <- result deleteFestival FestivalController");
		
		return "redirect:/festival/ingFestivalList";
	}
	
}
