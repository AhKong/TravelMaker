package com.cafe24.travelMaker.domain;

public class ResScrap {

	private String rsNum;
	private String mId;
	private String rNum;
	private String tNum;
	private String rData;
	public String getRsNum() {
		return rsNum;
	}
	public void setRsNum(String rsNum) {
		this.rsNum = rsNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String gettNum() {
		return tNum;
	}
	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	public String getrData() {
		return rData;
	}
	public void setrData(String rData) {
		this.rData = rData;
	}
	@Override
	public String toString() {
		return "ResScrap [rsNum=" + rsNum + ", mId=" + mId + ", rNum=" + rNum + ", tNum=" + tNum + ", rData=" + rData
				+ "]";
	}
	
	

}
