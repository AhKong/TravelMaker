package com.cafe24.travelMaker.domain;

public class MyTrip {

	private String tNum;
	private String mId;
	private String tName;
	private String oCheck;
	private String tUrl;
	private String sDate;
	private String eDate;
	private String status;
	private String rDate;
	private String tPhoto;
	public String gettNum() {
		return tNum;
	}
	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getoCheck() {
		return oCheck;
	}
	public void setoCheck(String oCheck) {
		this.oCheck = oCheck;
	}
	public String gettUrl() {
		return tUrl;
	}
	public void settUrl(String tUrl) {
		this.tUrl = tUrl;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public String gettPhoto() {
		return tPhoto;
	}
	public void settPhoto(String tPhoto) {
		this.tPhoto = tPhoto;
	}
	@Override
	public String toString() {
		return "MyTrip [tNum=" + tNum + ", mId=" + mId + ", tName=" + tName + ", oCheck=" + oCheck + ", tUrl=" + tUrl
				+ ", sDate=" + sDate + ", eDate=" + eDate + ", status=" + status + ", rDate=" + rDate + ", tPhoto="
				+ tPhoto + "]";
	}
	
	
}
