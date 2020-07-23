package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.domain.TripPlan;
import com.cafe24.travelMaker.mapper.TripPlanMapper;

@Service
public class TripPlanService {

	@Autowired public TripPlanMapper tripPlanMapper;
	public int TripNameInsert(MyTrip myTrip) {
		return tripPlanMapper.TripNameInsert(myTrip);
	}
	public String myTripNum(String tNum) {
		return tripPlanMapper.myTripNum(tNum);
	}
	public List<TripPlan> selectTripPlan(String mId, String tNum) {
		return tripPlanMapper.selectTripPlan(mId, tNum);
	}
	public List<TripPlan> sTripPlan(){
		return tripPlanMapper.sTripPlan();
	}
	public int deleteTripPlan(String mId, String tNum) {
		return tripPlanMapper.deleteTripPlan(mId, tNum);
	}
	public String sTripMid(String tNum) {
		return tripPlanMapper.sTripMid(tNum);
	}
}
