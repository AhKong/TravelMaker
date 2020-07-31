package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.domain.SightsScrap;
import com.cafe24.travelMaker.domain.TripPlan;

@Mapper
public interface TripPlanMapper {

	public String tripName(TripPlan tName);
	public String myTripNum(String tNum);
	public int TripNameInsert(MyTrip myTrip);
	public List<TripPlan> selectTripPlan(String mId, String tNum);
	public List<TripPlan> sTripPlan();
	public int deleteTripPlan(String tNum);
	public List<MyTrip> sTripMid(String tNum);
	public MyTrip sMyTrip(String tNum);
	public String selectTnum();
	public int planInsert(String mId, String pCost, String pSupply, String pDetail,String tNum);
	public int deleteTripPlanEmpty(String tNum);
	public List<SightsScrap> ScrapList(String mId, String tNum);
	public int planUpdate(String pNum, String pCost, String pSupply, String pDetail);
}
