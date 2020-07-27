package com.cafe24.travelMaker.domain;

public class MemberLogin {
	private String logNum;
	private String mId;
	private String logDate;
	private String logOutDate;
	public String getLogNum() {
		return logNum;
	}
	public void setLogNum(String logNum) {
		this.logNum = logNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getLogOutDate() {
		return logOutDate;
	}
	public void setLogOutDate(String logOutDate) {
		this.logOutDate = logOutDate;
	}
	@Override
	public String toString() {
		return "MemberLogin [logNum=" + logNum + ", mId=" + mId + ", logDate=" + logDate + ", logOutDate=" + logOutDate
				+ "]";
	}
	
	
}
