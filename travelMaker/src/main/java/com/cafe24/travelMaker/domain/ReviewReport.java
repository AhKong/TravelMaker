package com.cafe24.travelMaker.domain;

public class ReviewReport {
	private String reviewReportNum;
	private String mId;
	private String reviewNum;
	private ReportType reportType;
	private String reportContents;
	private String reviewType;
	public String getReviewReportNum() {
		return reviewReportNum;
	}
	public void setReviewReportNum(String reviewReportNum) {
		this.reviewReportNum = reviewReportNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public ReportType getReportType() {
		return reportType;
	}
	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}
	public String getReportContents() {
		return reportContents;
	}
	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}
	public String getReviewType() {
		return reviewType;
	}
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	@Override
	public String toString() {
		return "ReviewReport [reviewReportNum=" + reviewReportNum + ", mId=" + mId + ", reviewNum=" + reviewNum
				+ ", reportType=" + reportType + ", reportContents=" + reportContents + ", reviewType=" + reviewType
				+ "]";
	}

}
