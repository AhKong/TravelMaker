package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.travelMaker.mapper.StatsMapper;

@Controller
public class StatsController {

	@Autowired StatsMapper statsMapper;
	@GetMapping("/stats")
	public String stats(Model model) {
		String cntsm = statsMapper.sigGenderM();
		System.out.println(cntsm);
		model.addAttribute("sigGenderM", cntsm);
		
		String nctsg = statsMapper.siggenderG();
		System.out.println(nctsg);
		model.addAttribute("siggenderG", nctsg);
		//Stats genderM = statsMapper.sigGenderM(sigGenderM);
		//System.out.println(genderM);
		return "stats/stats";
	}
}
