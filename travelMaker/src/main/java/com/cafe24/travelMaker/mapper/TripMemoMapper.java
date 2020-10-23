package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.TripMemo;
import com.cafe24.travelMaker.domain.TripPlan;

@Mapper
public interface TripMemoMapper {
	
	//내여행기록 등록
	public int addTripMemo(TripMemo tripMemo);
	public List<TripPlan> getTripPlanList(String mId);
	
	//내여행기록 리스트(메인화면)
	public List<TripMemo> tripMemoList(String mId);
	
	//내여행기록 수정
	public int updateTripMemo(TripMemo tripMemo, String mId);
}
