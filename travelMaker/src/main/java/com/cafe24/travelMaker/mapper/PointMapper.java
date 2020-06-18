package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Point;
import com.cafe24.travelMaker.domain.SavePoint;
@Mapper
public interface PointMapper {
	//포인트 적립 
	public int savePoint(SavePoint savePoint);
	public int isMyPoint(String mId);	
	public int addMyPoint(Point point);
	public int updateMyPoint(Point point); 

}
