package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.domain.Point;
import com.cafe24.travelMaker.domain.SavePoint;
import com.cafe24.travelMaker.mapper.PointMapper;
/**
	포인트에 대한 모든 서비스 
*/
@Service
public class PointService {
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
	
	public Point getPointInfo(String mId) {
		return pointMapper.getPointInfo(mId);
	}
	
	public int updatePointFinal(Goods goods) {
		return pointMapper.updatePointFinal(goods);
	}
	public int pointUseAdmin(Goods goods) {
		return pointMapper.pointUseAdmin(goods);
	}
	
	
	//마이페이지 - 포인트 사용내역
	public List<Point> pointUseList(String loginId) {
		System.out.println("pointUseList PointSerivce 도착");
		System.out.println(loginId+" <- loginID pointUseList PointSerivce");
		List<Point> useList = pointMapper.pointUseList(loginId);
		System.out.println(useList+" <- useList pointUseList PointSerivce");
		
		return useList;
	}
	
	//마이페이지 - 포인트 적립내역
	public List<Point> pointSaveList(String loginId) {
		System.out.println("pointSaveList PointSerivce 도착");
		System.out.println(loginId+" <- loginID pointSaveList PointSerivce");
		List<Point> saveList = pointMapper.pointSaveList(loginId);
		System.out.println(saveList+" <- saveList pointSaveList PointSerivce");
		
		return saveList;
	}
	
	//마이페이지 - 총 소유 포인트
	public List<Point> getTotalPoint(String loginId) {
		System.out.println("totalPoint PointSerivce 도착");
		List<Point> totalPoint = pointMapper.getTotalPoint(loginId);
		System.out.println(totalPoint+" <- totalPoint");
		
		return totalPoint;
	}
	
	//관리자페이지 - 회원들의 포인트 사용내역
	public List<Point> pointUseAdminList() {
		System.out.println("pointUseAdminList PointSerivce 도착");
		List<Point> pointUseAdmin = pointMapper.pointUseAdminList();
		System.out.println(pointUseAdmin+" <- pointUseAdmin pointUseAdminList PointService");
		
		return pointUseAdmin;
	}
	
	//관리자페이지 - 회원들의 포인트 적립내역
	public List<Point> pointSaveAdminList() {
		System.out.println("pointSaveAdminList PointSerivce 도착");
		List<Point> pointSaveAdmin = pointMapper.pointSaveAdminList();
		System.out.println(pointSaveAdmin+" <- pointSaveAdmin pointSaveAdminList PointService");
		
		return pointSaveAdmin;
	}
	
}
