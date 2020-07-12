package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.mapper.MyTripMapper;


@Service
public class MyTripService {

	@Autowired MyTripMapper myTripMapper;
	public List<MyTrip> sightsList(String mId) {
		
		return myTripMapper.selectMyTrip(mId);
	}
	public List<MyTrip> openList(String mId) {
		
		return myTripMapper.openMyTrip(mId);
	}
	public List<MyTrip> hideList(String mId) {
		
		return myTripMapper.hideMyTrip(mId);
	}
	public List<MyTrip> scrapList(String mId) {
		
		return myTripMapper.scrapMyTrip(mId);
	}
	
}
