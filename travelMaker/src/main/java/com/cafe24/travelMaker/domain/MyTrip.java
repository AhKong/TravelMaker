package com.cafe24.travelMaker.domain;

public class MyTrip {

	private String tNum;
	private String mId;
	private String tName;
	private String oCheck;
	private String tUrl;
	private String sDate;
	private String eDate;
	private String tStatus;
	private String rDate;
	private String tPhoto;
	private String sightsNum;
	private String sPhoto;
	private String sName;
	
	
	public String getsPhoto() {
		return sPhoto;
	}
	public void setsPhoto(String sPhoto) {
		this.sPhoto = sPhoto;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String gettStatus() {
		return tStatus;
	}
	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}
	public String gettPhoto() {
		return tPhoto;
	}
	public void settPhoto(String tPhoto) {
		this.tPhoto = tPhoto;
	}
	public String getSightsPhoto() {
		return sPhoto;
	}
	public void setSightsPhoto(String sightsPhoto) {
		this.sPhoto = sightsPhoto;
	}
	public String getSightsNum() {
		return sightsNum;
	}
	public void setSightsNum(String sightsNum) {
		this.sightsNum = sightsNum;
	}
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
	public void setsDate(String startDate) {
		this.sDate = startDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public String getStatus() {
		return tStatus;
	}
	public void setStatus(String status) {
		this.tStatus = status;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public String getTPhoto() {
		return tPhoto;
	}
	public void setTPhoto(String tPhoto) {
		this.tPhoto = tPhoto;
	}
	@Override
	public String toString() {
		return "MyTrip [tNum=" + tNum + ", mId=" + mId + ", tName=" + tName + ", oCheck=" + oCheck + ", tUrl=" + tUrl
				+ ", sDate=" + sDate + ", eDate=" + eDate + ", tStatus=" + tStatus + ", rDate=" + rDate + ", tPhoto="
				+ tPhoto + ", sightsNum=" + sightsNum + ", sPhoto=" + sPhoto + ", sName=" + sName + "]";
	}

	
}
