package com.cafe24.travelMaker.domain;

public class ResCate {
	private String resCateNum;
	private String resType;
	public String getResCateNum() {
		return resCateNum;
	}
	public void setResCateNum(String resCateNum) {
		this.resCateNum = resCateNum;
	}
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	@Override
	public String toString() {
		return "ResCate [resCateNum=" + resCateNum + ", resType=" + resType + "]";
	}
	

}
