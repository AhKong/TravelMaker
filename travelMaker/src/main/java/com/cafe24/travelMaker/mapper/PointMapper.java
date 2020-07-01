package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.domain.Point;
import com.cafe24.travelMaker.domain.SavePoint;

@Mapper
public interface PointMapper {
	//포인트 적립 
	public int savePoint(SavePoint savePoint);
	public int isMyPoint(String mId);	
	public int addMyPoint(Point point);
	public int updateMyPoint(Point point); 
	public Point getPointInfo(String mId);
	public int updatePointFinal(Goods goods);
	
	//마이페이지 - 포인트 사용내역
	public List<Point> pointUseList(String loginId);
	public List<Point> pointSaveList(String loginId);
	public List<Point> getTotalPoint(String loginId);
	
	//관리자 - 포인트 관리페이지
	public List<Point> pointUseAdminList();
}
