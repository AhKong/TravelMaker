package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.TripMemo;
import com.cafe24.travelMaker.domain.TripPlan;
import com.cafe24.travelMaker.mapper.TripMemoMapper;

@Service
public class TripMemoService {

	@Autowired TripMemoMapper tripMemoMapper;
	
	//내여행기록 리스트
	public List<TripMemo> tripMemoList() {
		System.out.println("tripMemoList TripMemoController 도착");
		List<TripMemo> memoList = tripMemoMapper.tripMemoList();
		System.out.println(memoList+" <- memoList");
		
		return memoList;
	}
	
	//내여행기록 등록
	public int addTripMemo(TripMemo tripMemo) {
		System.out.println("addTripMemo TripMemoService 도착");
		int result = tripMemoMapper.addTripMemo(tripMemo);
		System.out.println(result+" <- 1 이면 내여행기록 등록 완료! 0 이면 실패,,");
		
		return result;
	}
	
	//기록 등록  후  내여행계획 불러오기
	public List<TripPlan> getTripPlanList(String mId){
		System.out.println("getTripPlanList TripMemoService 도착");
		
		return tripMemoMapper.getTripPlanList(mId);
	}
}
