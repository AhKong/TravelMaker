package com.cafe24.travelMaker.domain;

public class ReportType {
	private String reportTypeNum;
	private String reportTypeName;
	public String getReportTypeNum() {
		return reportTypeNum;
	}
	public void setReportTypeNum(String reportTypeNum) {
		this.reportTypeNum = reportTypeNum;
	}
	public String getReportTypeName() {
		return reportTypeName;
	}
	public void setReportTypeName(String reportTypeName) {
		this.reportTypeName = reportTypeName;
	}
	@Override
	public String toString() {
		return "ReportType [reportTypeNum=" + reportTypeNum + ", reportTypeName=" + reportTypeName + "]";
	}

}
