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
		System.out.println(cntsm + "<--- 관광지 남자");
		model.addAttribute("sigGenderM", cntsm);
		
		String nctsg = statsMapper.siggenderG();
		System.out.println(nctsg + "<--- 관광지 여자");
		model.addAttribute("siggenderG", nctsg);
		
		String cntreview = statsMapper.review();
			System.out.println(cntreview + "<--- 관광지 리뷰");
			model.addAttribute("review", cntreview);
			
		int cntlike = statsMapper.like();
		System.out.println(cntlike + "<--- 좋아유");
		model.addAttribute("like", cntlike);

		int cntcomment = statsMapper.comment();
		System.out.println(cntcomment + "<--- 댓글");
		model.addAttribute("comment", cntcomment);
		
		return "stats/stats";
	}
}
