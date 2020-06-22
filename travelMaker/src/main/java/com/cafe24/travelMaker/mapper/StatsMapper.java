package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Stats;

@Mapper
public interface StatsMapper {
	//관광지
	public String sigGenderM();
	public String siggenderG();
	public String review();
	public int like();
	public int comment();
	public Stats grade(Stats grade);
	//음식점
	public Stats resGenderM(Stats resGenderM);
	public Stats resGenderG(Stats resGenderG);
	public Stats resReview(Stats resReview);
	public Stats resGrade(Stats resReview);
}
