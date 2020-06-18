package com.cafe24.travelMaker.domain;

public class SavePoint {
	private String savePointNum;
	private String mId;
	private String savePointCause;
	private String savePointDetail;
	private int savePointCharge;
	private String savePointRegDate;
	public String getSavePointNum() {
		return savePointNum;
	}
	public void setSavePointNum(String savePointNum) {
		this.savePointNum = savePointNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getSavePointCause() {
		return savePointCause;
	}
	public void setSavePointCause(String savePointCause) {
		this.savePointCause = savePointCause;
	}
	public String getSavePointDetail() {
		return savePointDetail;
	}
	public void setSavePointDetail(String savePointDetail) {
		this.savePointDetail = savePointDetail;
	}
	public int getSavePointCharge() {
		return savePointCharge;
	}
	public void setSavePointCharge(int savePointCharge) {
		this.savePointCharge = savePointCharge;
	}
	public String getSavePointRegDate() {
		return savePointRegDate;
	}
	public void setSavePointRegDate(String savePointRegDate) {
		this.savePointRegDate = savePointRegDate;
	}
	@Override
	public String toString() {
		return "Point [savePointNum=" + savePointNum + ", mId=" + mId + ", savePointCause=" + savePointCause
				+ ", savePointDetail=" + savePointDetail + ", savePointCharge=" + savePointCharge
				+ ", savePointRegDate=" + savePointRegDate + "]";
	}
	
	

}
