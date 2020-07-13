package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.mapper.TripPlanMapper;

@Service
public class TripPlanService {

	@Autowired public TripPlanMapper tripPlanMapper;
	public int TripNameInsert(MyTrip myTrip) {
		return tripPlanMapper.TripNameInsert(myTrip);
	}
}
