package com.cafe24.travelMaker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.Res;
import com.cafe24.travelMaker.service.ResService;
import com.cafe24.travelMaker.service.SightsService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
@RequestMapping("/res")
public class ResController {
	@Autowired private ResService resService;
	@Autowired private SightsService sightsService;
	@Autowired private StorageService storageService;
	
	@GetMapping("/resList")
	public String resList(Model model, @RequestParam (name="search") String search) {
		System.out.println(search +"<---search");
		System.out.println(resService.getResList(search));
		model.addAttribute("search", search);
		model.addAttribute("resList", resService.getResList(search));
		return "/res/resList";
	}
	
	@GetMapping("/addRes")
	public String addRes(Model model) {
		model.addAttribute("resList", resService.selectResCate());
		model.addAttribute("doList",sightsService.selectDo());
		return "/res/addRes";
	}
	
	@PostMapping("/addRes")
	public String addRes(Res res) {
		System.out.println(res+"<----res");
		res.setResPhoto(res.getFile().getOriginalFilename());
		if(!"".equals(res.getResPhoto())) {
			storageService.store(res.getFile());
		}
		int result = resService.addRes(res);
		System.out.println(result +"<---addRes result ");
		return "redirect:/";
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
