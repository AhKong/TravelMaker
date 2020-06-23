package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.SightsFeedback;

@Mapper
public interface FeedbackMapper {

	//피드백 폼 이동
	public String formFeedback(String sightsNum);
	
	//피드백 보내기
	public int addFeedback(SightsFeedback sightsFeedback);
}
