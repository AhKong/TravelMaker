package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.SavePoint;
@Mapper
public interface PointMapper {
	//포인트 적립 
	public int addPoint(SavePoint savePoint);
	
	//포인트 사용내역에 추가
}
