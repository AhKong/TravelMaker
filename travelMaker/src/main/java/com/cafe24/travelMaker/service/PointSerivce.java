package com.cafe24.travelMaker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Point;
import com.cafe24.travelMaker.domain.SavePoint;
import com.cafe24.travelMaker.mapper.PointMapper;
/**
	포인트에 대한 모든 서비스 
*/
@Service
public class PointSerivce {
	@Autowired private PointMapper pointMapper;
	private SavePoint savePoint= new SavePoint();
	private Point point = new Point();

	//회원가입시 포인트 적립내용 셋팅
	public SavePoint setSavePointForJoin(String mId) {
		this.savePoint.setmId(mId);
		this.savePoint.setSavePointCause("회원가입");
		this.savePoint.setSavePointCharge(2000);
		return this.savePoint;
	}
	
	// 회원가입 하면 포인트 관리 테이블에  insert 하려고!!
	public int setPoint() {
		this.point.setmId(this.savePoint.getmId());
		this.point.setFinalPoint(this.savePoint.getSavePointCharge());
		int result = pointMapper.addMyPoint(this.point);
		return result;
	}
	//포인트 적립
	public int savePoint() {
		return pointMapper.savePoint(this.savePoint);
	}
	
	public int isMyPoint(String mId) {
		
		return 0;
	}
	
	// 회원가입시 생성!!!!
	public int addMyPoint() {
		return 0;
	}
	
	public int updateMyPoint() {
		return 0;
	}
	
	public int process() {
		
		return 0;
	}
	
	
}
