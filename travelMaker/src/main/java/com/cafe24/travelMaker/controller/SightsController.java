package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

import com.cafe24.travelMaker.domain.Si;
import com.cafe24.travelMaker.domain.Sights;
import com.cafe24.travelMaker.service.SightsService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
public class SightsController{
	@Autowired private SightsService sightsService;
	@Autowired private StorageService storageService;
	
	@GetMapping("/sightsList")
	public String sightsList(Model model,@RequestParam(name="search") String search) {
		System.out.println(search+"<---");
		System.out.println(sightsService.selectSightsList(search));
		model.addAttribute("searchWord", search);
		model.addAttribute("sightsList", sightsService.selectSightsList(search));
		return "/sights/sightsList";
	}
	
	@GetMapping ("/addSights")
	public String addSights(Model model) {
		model.addAttribute("cateList", sightsService.selectSightsCate());
		model.addAttribute("doList",sightsService.selectDo());
		return "/sights/addSights";
	}
	
	@PostMapping("/addSights")
	public String addSights(Sights sights) {
		System.out.println(sights +"<---sights");
		sights.setSightsPhoto(sights.getFile().getOriginalFilename());
		if(!"".equals(sights.getSightsPhoto())) {
			storageService.store(sights.getFile());
		}
		int result = sightsService.addSights(sights);
		if(result >0) {
			return "redirect:/addSights";
		}
		
		return "redirect:/";
	}
	@GetMapping("/getSiList")

	public @ResponseBody HashMap<String,List<Si>> getSiList(@RequestParam(name="num") String doNum) {
		System.out.println(doNum+"<----doNum");
		HashMap <String,List<Si>> result = new HashMap <String,List<Si>>();
		result.put("siList",sightsService.selectSi(doNum));
		return result;
		
	}
	
	@GetMapping("/updateSights")
	public String updateSights() {
		return "/sights/updateSights";
	}
	
	@GetMapping("/detailSights")
	public String detailSights() {
		return "/sights/detailSights";
	}
	
	@GetMapping("/moreSightsPhoto")
	public String moreSightsPhoto() {
		return "/sights/morePhotos";
	}
}
