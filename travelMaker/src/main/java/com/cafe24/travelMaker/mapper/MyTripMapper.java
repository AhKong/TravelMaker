package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.MyTrip;


@Mapper
public interface MyTripMapper {

	public List<MyTrip> selectMyTrip(String mId);
	public List<MyTrip> openMyTrip(String mId);
	public List<MyTrip> hideMyTrip(String mId);
	public List<MyTrip> scrapMyTrip(String mId);

}
