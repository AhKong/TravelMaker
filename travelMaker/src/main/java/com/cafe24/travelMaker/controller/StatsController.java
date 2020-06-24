package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.travelMaker.mapper.StatsMapper;

@Controller
@RequestMapping("/stats")
public class StatsController {

	@Autowired
	public StatsMapper statsMapper;

	@GetMapping("/stats")
	public String stats(Model model) {

		// 관광지
		String cntSM = statsMapper.sigGenderM();
		System.out.println(cntSM + "<--- 관광지 남자");
		model.addAttribute("sigGenderM", cntSM);

		String nctSG = statsMapper.siggenderG();
		System.out.println(nctSG + "<--- 관광지 여자");
		model.addAttribute("siggenderG", nctSG);

		String cntReview = statsMapper.review();
		System.out.println(cntReview + "<--- 관광지 리뷰");
		model.addAttribute("review", cntReview);

		int cntLike = statsMapper.like();
		System.out.println(cntLike + "<--- 좋아유");
		model.addAttribute("like", cntLike);

		int cntComment = statsMapper.comment();
		System.out.println(cntComment + "<--- 댓글");
		model.addAttribute("comment", cntComment);

		int cntSightGrade = statsMapper.grade();
		System.out.println(cntSightGrade + "<--- 별점");
		model.addAttribute("grade", cntSightGrade);

		
		// 음식점
		int cntRM = statsMapper.resGenderM();
		System.out.println(cntRM + "<--- 음식점 남자");
		model.addAttribute("resGenderM", cntRM);

		int cntRG = statsMapper.resGenderG();
		System.out.println(cntRG + "<--- 음식점 여자");
		model.addAttribute("resGenderG", cntRG);

		int cntResReview = statsMapper.resReview();
		System.out.println(cntResReview);
		model.addAttribute("resReview", cntResReview);

		int cntResGrade = statsMapper.resGrade();
		System.out.println(cntResGrade + "<--- 별점평균");
		model.addAttribute("resGrade", cntResGrade);

		return "stats/stats";
	}
}
