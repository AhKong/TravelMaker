package com.cafe24.travelMaker.domain;

public class TripPlan {

	private String sCode;
	private String mId;
	private String sNum;
	private String tNum;
	private String rDate;
	private String sYesNo;
	public String getsCode() {
		return sCode;
	}
	public void setsCode(String sCode) {
		this.sCode = sCode;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getsNum() {
		return sNum;
	}
	public void setsNum(String sNum) {
		this.sNum = sNum;
	}
	public String gettNum() {
		return tNum;
	}
	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public String getsTesNo() {
		return sYesNo;
	}
	public void setsTesNo(String sTesNo) {
		this.sYesNo = sTesNo;
	}
	@Override
	public String toString() {
		return "TripPlan [sCode=" + sCode + ", mId=" + mId + ", sNum=" + sNum + ", tNum=" + tNum + ", rDate=" + rDate
				+ ", sTesNo=" + sYesNo + "]";
	}
	
}
