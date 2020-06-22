package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackMapper {

	//피드백 보내기
	public int addFeeadback();
}
