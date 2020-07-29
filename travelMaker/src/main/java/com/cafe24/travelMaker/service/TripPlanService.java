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
	public int deleteTripPlan(String tNum) {
		return tripPlanMapper.deleteTripPlan(tNum);
	}
	public List<MyTrip> sTripMid(String tNum) {
		return tripPlanMapper.sTripMid(tNum);
	}
	public MyTrip sMyTrip(String tNum) {
		return tripPlanMapper.sMyTrip(tNum);
	}
	public String selectTnum() {
		return tripPlanMapper.selectTnum();
	}
	public int planInsert(String mId, String pCost, String pSupply, String pDetail, String tNum) {
		return tripPlanMapper.planInsert(mId,pCost,pSupply,pDetail,tNum);
	}
	public int deleteTripPlanEmpty(String tNum) {
		return tripPlanMapper.deleteTripPlanEmpty(tNum);
	}
}
