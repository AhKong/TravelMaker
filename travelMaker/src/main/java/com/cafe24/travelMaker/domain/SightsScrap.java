package com.cafe24.travelMaker.domain;

public class SightsScrap {

	private String ssNum;
	private String mId;
	private String sightsNum;
	private String tNum;
	private String sData;
	private boolean isScrap = false;

	public String getSsNum() {
		return ssNum;
	}
	public void setSsNum(String ssNum) {
		this.ssNum = ssNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
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
	public String getsData() {
		return sData;
	}
	public void setsData(String sData) {
		this.sData = sData;
	}
	
	public boolean isScrap() {
		return isScrap;
	}
	public void setScrap(boolean isScrap) {
		this.isScrap = isScrap;
	}
	@Override
	public String toString() {
		return "SightsScrap [ssNum=" + ssNum + ", mId=" + mId + ", sightsNum=" + sightsNum + ", tNum=" + tNum
				+ ", sData=" + sData + ", isScrap=" + isScrap + "]";
	}
	


}
