package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.domain.TripPlan;

@Mapper
public interface TripPlanMapper {

	public String tripName(TripPlan tName);
	public int TripNameInsert(MyTrip myTrip);
}
