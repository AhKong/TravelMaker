package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.TripMemo;

@Mapper
public interface TripMemoMapper {
	
	//내여행기록 등록
	public int addTripMemo(TripMemo tripMemo);
	
	//내여행기록 리스트(메인화면)
	public List<TripMemo> tripMemoList();
}
