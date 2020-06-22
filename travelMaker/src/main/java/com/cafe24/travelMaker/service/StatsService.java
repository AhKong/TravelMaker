package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Stats;
import com.cafe24.travelMaker.mapper.StatsMapper;

@Service
public class StatsService {
	@Autowired public StatsMapper statsMapper;
	
	public String sigGenderM() {
		System.out.println("관광지 남자 통계");
		return statsMapper.sigGenderM();
	}
	public String siggenderG() {
		System.out.println("관광지 여자 통계");
		return statsMapper.siggenderG();
	}
	public Stats review(Stats review) {
		System.out.println("관광지 리뷰 통계");
		return statsMapper.review(review);
	}
	public Stats like(Stats like) {
		System.out.println("관광지 좋아요 통계");
		return statsMapper.like(like);
	}
	public Stats comment(Stats comment) {
		System.out.println("관광지 댓글 통계");
		return statsMapper.comment(comment);
	}
	public Stats grade(Stats grade) {
		System.out.println("관광지 별점 통계");
		return statsMapper.grade(grade);
	}
	
	
	public Stats resGenderM(Stats resGenderM) {
		System.out.println("음식점 통계");
		return statsMapper.resGenderM(resGenderM);
	}
	public Stats resGenderG(Stats resGenderG) {
		System.out.println("음식점 통계");
		return statsMapper.resGenderG(resGenderG);
	}
	public Stats resReview(Stats resReview) {
		System.out.println("음식점 통계");
		return statsMapper.resReview(resReview);
	}
	public Stats resGrade(Stats resGrade) {
		System.out.println("음식점 통계");
		return statsMapper.resGrade(resGrade);
	}
}
