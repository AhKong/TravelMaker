package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.travelMaker.domain.KmaListDto;
import com.cafe24.travelMaker.service.WeatherService;


@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	WeatherService myService;
	
	@GetMapping("/weatherInfo")
	public String index(Model model) {
		KmaListDto kmaListDto = myService.myService("5000000000");
		
		System.out.println(kmaListDto);
		model.addAttribute("kmaListDto", kmaListDto);
		
		return "/weather/weatherInfo";
	}
	
	@RequestMapping(value = "/apiasdaadasddsadsadsadadsasadas", produces = "application/json")
	@ResponseBody
	public KmaListDto api(@RequestParam(name = "zone", required = false) String zone) {
		return myService.myService(zone);
	}
	
}
