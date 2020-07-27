package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ReportType;
import com.cafe24.travelMaker.domain.ReviewReport;
import com.cafe24.travelMaker.mapper.ReportMapper;

@Service
public class ReportService {

	@Autowired private ReportMapper reportMapper;
	@Autowired private ReviewService reviewService;
	@Autowired private NoticeService noticeService;
	
	public List<ReportType> getReportType(){
		return reportMapper.getReportType();
	}
	public int reportSightsReivew(ReviewReport reviewReport) {
		return reportMapper.reportSightsReivew(reviewReport);
	}
	public int isReportedReview(String mId, String reviewNum) {
		return reportMapper.isReportedReview(mId, reviewNum);
	}
	
	public int reportResReivew(ReviewReport reviewReport) {
		return reportMapper.reportResReivew(reviewReport);
	}
	
	public List<ReviewReport> reportList(String reviewType){
		return reportMapper.reportList(reviewType);
	}
	
	public int chagneReportPro(String reportNum,String reviewType,String reviewNum) {
		String reviewWriter= null;
		System.out.println(reviewType +"<----reviewType");
		int result = 0; 
		if("Res".equals(reviewType)) {
			System.out.println("영이이기기!!");
			reviewWriter = reviewService.findResReviewWriter(reviewNum);
		} else {
			reviewWriter = reviewService.findSightsReviewWriter(reviewNum);
		}
		result += noticeService.addNoticeForReport(reviewWriter);
		result += reportMapper.chagneReportPro(reportNum);
		return result;
	}
}
