package com.cafe24.travelMaker.domain;

public class FbCode {

	private String fbNum;
	private String fbReason;
	private String fbRegDate;
	
	public String getFbNum() {
		return fbNum;
	}
	public void setFbNum(String fbNum) {
		this.fbNum = fbNum;
	}
	public String getFbReason() {
		return fbReason;
	}
	public void setFbReason(String fbReason) {
		this.fbReason = fbReason;
	}
	public String getFbRegDate() {
		return fbRegDate;
	}
	public void setFbRegDate(String fbRegDate) {
		this.fbRegDate = fbRegDate;
	}
	
	@Override
	public String toString() {
		return "FbCode [fbNum=" + fbNum + ", fbReason=" + fbReason + ", fbRegDate=" + fbRegDate + "]";
	}
	
}
