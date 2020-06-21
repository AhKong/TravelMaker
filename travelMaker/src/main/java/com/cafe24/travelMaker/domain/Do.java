package com.cafe24.travelMaker.domain;

public class Do {
	private String doNum;
	private String mId;
	private String doName;
	private String doRegDate;
	private String doUpdateDate;
	public String getDoNum() {
		return doNum;
	}
	public void setDoNum(String doNum) {
		this.doNum = doNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getDoName() {
		return doName;
	}
	public void setDoName(String doName) {
		this.doName = doName;
	}
	public String getDoRegDate() {
		return doRegDate;
	}
	public void setDoRegDate(String doRegDate) {
		this.doRegDate = doRegDate;
	}
	public String getDoUpdateDate() {
		return doUpdateDate;
	}
	public void setDoUpdateDate(String doUpdateDate) {
		this.doUpdateDate = doUpdateDate;
	}
	@Override
	public String toString() {
		return "Do [doNum=" + doNum + ", mId=" + mId + ", doName=" + doName + ", doRegDate=" + doRegDate
				+ ", doUpdateDate=" + doUpdateDate + "]";
	}

}
