package com.cafe24.travelMaker.domain;

public class SightsScrap {

	private String ssNum;
	private String mId;
	private String sightsNum;
	private String tNum;
	private String sData;

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

	@Override
	public String toString() {
		return "SightsScrap [sNum=" + ssNum + ", mId=" + mId + ", sightsNum=" + sightsNum + ", tripNum=" + tNum
				+ ", SData=" + sData + "]";
	}
	
	
}
