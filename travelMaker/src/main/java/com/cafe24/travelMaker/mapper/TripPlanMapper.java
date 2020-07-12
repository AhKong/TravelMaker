package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.TripPlan;

@Mapper
public interface TripPlanMapper {
//여행리스트 모달에서 리스트 인설트 해야해
	public String tripName(TripPlan tName);
}
