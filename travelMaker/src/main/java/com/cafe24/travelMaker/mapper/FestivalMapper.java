package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Festival;

@Mapper
public interface FestivalMapper {

	
	
	
	//축제 등록
	public int addFestival(Festival festival);
	
}
