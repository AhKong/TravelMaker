package com.cafe24.travelMaker.domain;

public class TripPlan {

	private String pNum;
	private String tNum;
	private String mId;
	private String pDate;
	private String pCost;
	private String pSupply;
	private String pDetail;
	private String pRegData;
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
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
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public String getpCost() {
		return pCost;
	}
	public void setpCost(String pCost) {
		this.pCost = pCost;
	}
	public String getpSupply() {
		return pSupply;
	}
	public void setpSupply(String pSupply) {
		this.pSupply = pSupply;
	}
	public String getpDetail() {
		return pDetail;
	}
	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}
	public String getpRegData() {
		return pRegData;
	}
	public void setpRegData(String pRegData) {
		this.pRegData = pRegData;
	}
	@Override
	public String toString() {
		return "TripPlan [pNum=" + pNum + ", tNum=" + tNum + ", mId=" + mId + ", pDate=" + pDate + ", pCost=" + pCost
				+ ", pSupply=" + pSupply + ", pDetail=" + pDetail + ", pRegData=" + pRegData + "]";
	}
	
}
