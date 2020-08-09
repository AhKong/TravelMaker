package com.cafe24.travelMaker.service;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	@Autowired private NoticeService noticeService;
	private SavePoint savePoint = new SavePoint();
	private Point point = new Point();

	//회원가입시 포인트 적립 
	public int SavePointForJoin(String mId) {
		this.savePoint.setmId(mId);
		this.savePoint.setSavePointCause("회원가입");
		this.savePoint.setSavePointCharge(2000);
		
		this.point.setmId(this.savePoint.getmId());
		this.point.setFinalPoint(this.savePoint.getSavePointCharge());
		pointMapper.addMyPoint(point);
		noticeService.addNototiceForSavePoint(this.savePoint.getmId(), this.savePoint.getSavePointCharge(), this.savePoint.getSavePointCause());
		return pointMapper.savePoint(this.savePoint);
	}
	
	public int setSavePointForReview(String mId ,int point,String detail) {
		this.savePoint.setmId(mId);
		this.savePoint.setSavePointCharge(point);
		this.savePoint.setSavePointCause("리뷰작성");
		this.savePoint.setSavePointDetail(detail);
		
		this.point.setmId(mId);
		this.point.setFinalPoint(point);
		
		pointMapper.updateMyPoint(this.point);
		noticeService.addNototiceForSavePoint(this.savePoint.getmId(), this.savePoint.getSavePointCharge(), this.savePoint.getSavePointCause());
		return pointMapper.savePoint(this.savePoint);

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
	public List<Point> pointUseList(String mId) {
		System.out.println("pointUseList PointSerivce 도착");
		System.out.println(mId+" <- mId pointUseList PointSerivce");
		List<Point> useList = pointMapper.pointUseList(mId);
		System.out.println(useList+" <- useList pointUseList PointSerivce");
		
		return useList;
	}
	
	//마이페이지 - 포인트 적립내역
	public List<Point> pointSaveList(String mId) {
		System.out.println("pointSaveList PointSerivce 도착");
		System.out.println(mId+" <- mId pointSaveList PointSerivce");
		List<Point> saveList = pointMapper.pointSaveList(mId);
		System.out.println(saveList+" <- saveList pointSaveList PointSerivce");
		
		return saveList;
	}
	
	//마이페이지 - 총 소유 포인트
	public List<Point> getTotalPoint(String mId) {
		System.out.println("totalPoint PointSerivce 도착");
		List<Point> totalPoint = pointMapper.getTotalPoint(mId);
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
	
	//피드백 수용 시 포인트 지급 2000점
	public int savePointForFeedback(String sightsNum, String resNum, String mId) {
		System.out.println("savePointForFeedback PointService 도착");
		this.savePoint.setmId(mId);		//피드백 작성한 회원의 id
		this.savePoint.setSavePointCause("피드백 수용");
		this.savePoint.setSavePointCharge(2000);
		if(sightsNum != null && resNum == null) {			//관광명소 피드백 수용
			this.savePoint.setSavePointDetail(sightsNum);
		}else if(sightsNum == null && resNum != null) {		//음식점 피드백 수용
			this.savePoint.setSavePointDetail(resNum);
		}
		int saveResult = pointMapper.savePoint(savePoint);		//피드백 포인트 적립
		System.out.println(saveResult+" <- 1 이면 피드백 포인트 2000점 지급 완료");
		this.point.setmId(mId);
		this.point.setFinalPoint(2000);
		int finalResult = pointMapper.updateMyPoint(point);		//최종 포인트 업데이트
		System.out.println(finalResult+" <- 1 이면 최종포인트 + 피드백 포인트 2000점 업데이트 완료");
		int noticeResult = noticeService.addNototiceForSavePoint(mId, this.savePoint.getSavePointCharge(), this.savePoint.getSavePointCause());
		System.out.println(noticeResult+" <- 1 이면 포인트 지급 알람 완료");
		int result = saveResult+finalResult+noticeResult;
		System.out.println(result+" <- 3 이면 피드백 수용 처리 완료!!!");
		
		return result;
	}
	
	//최초 1회 탈퇴 회유 시 포인트 지급 2000점
	public int savePointForConciliateDeleteMember(String mId) {
		System.out.println("savePointForConciliateDeleteMember PointService 탈퇴회유 포인트 도착");
		this.savePoint.setmId(mId);
		this.savePoint.setSavePointCause("탈퇴 회유");
		this.savePoint.setSavePointCharge(2000);
		int conciliatePoint = pointMapper.savePoint(savePoint);			//탈퇴 회유 포인트 지급
		this.point.setmId(mId);
		this.point.setFinalPoint(2000);
		int conciliateUpdatePoint = pointMapper.updateMyPoint(point);	//최종 포인트 업데이트
		int conciliateNotice = noticeService.addNototiceForSavePoint(mId, this.savePoint.getSavePointCharge(), this.savePoint.getSavePointCause());
			//포인트 지급 알람
		
		return conciliatePoint+conciliateUpdatePoint+conciliateNotice;
	}
}
