package com.cafe24.travelMaker.domain;

public class SightsCate {
	private String sightsCateNum;
	private String sightsType;
	public String getSightsCateNum() {
		return sightsCateNum;
	}
	public void setSightsCateNum(String sightsCateNum) {
		this.sightsCateNum = sightsCateNum;
	}
	public String getSightsType() {
		return sightsType;
	}
	public void setSightsType(String sightsType) {
		this.sightsType = sightsType;
	}
	@Override
	public String toString() {
		return "SightsCate [sightsCateNum=" + sightsCateNum + ", sightsType=" + sightsType + "]";
	}
	
}
