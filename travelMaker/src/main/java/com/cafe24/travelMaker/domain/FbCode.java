package com.cafe24.travelMaker.domain;

public class FbCode {

	private String fbCodeNum;
	private String fbReason;
	private String fbCodeRegDate;
	
	public String getFbCodeNum() {
		return fbCodeNum;
	}
	public void setFbCodeNum(String fbCodeNum) {
		this.fbCodeNum = fbCodeNum;
	}
	public String getFbReason() {
		return fbReason;
	}
	public void setFbReason(String fbReason) {
		this.fbReason = fbReason;
	}
	public String getFbCodeRegDate() {
		return fbCodeRegDate;
	}
	public void setFbCodeRegDate(String fbCodeRegDate) {
		this.fbCodeRegDate = fbCodeRegDate;
	}
	
	@Override
	public String toString() {
		return "FbCode [fbCodeNum=" + fbCodeNum + ", fbReason=" + fbReason + ", fbCodeRegDate=" + fbCodeRegDate + "]";
	}
	
}
