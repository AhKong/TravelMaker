package com.cafe24.travelMaker.domain;
// 포인트 관리내역  DTO
public class Point {
		//포인트 관리
	private String pointNum;
	private String mId;
	private int finalPoint;
	private String pointRegDate;
		//포인트 사용
	private String pointUseNum;
	private String gNum;
	private String pointUseUsed;
	private String pointUseRegDate;
	private Goods goods;
		//포인트 적립
	private String savePointNum;
	private String savePointCause;
	private String savePointDetail;
	private String savePointCharge;
	private String savePointRegDate;
	
	public String getPointNum() {
		return pointNum;
	}
	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getFinalPoint() {
		return finalPoint;
	}
	public void setFinalPoint(int finalPoint) {
		this.finalPoint = finalPoint;
	}
	public String getPointRegDate() {
		return pointRegDate;
	}
	public void setPointRegDate(String pointRegDate) {
		this.pointRegDate = pointRegDate;
	}
	public String getPointUseNum() {
		return pointUseNum;
	}
	public void setPointUseNum(String pointUseNum) {
		this.pointUseNum = pointUseNum;
	}
	public String getgNum() {
		return gNum;
	}
	public void setgNum(String gNum) {
		this.gNum = gNum;
	}
	public String getPointUseUsed() {
		return pointUseUsed;
	}
	public void setPointUseUsed(String pointUseUsed) {
		this.pointUseUsed = pointUseUsed;
	}
	public String getPointUseRegDate() {
		return pointUseRegDate;
	}
	public void setPointUseRegDate(String pointUseRegDate) {
		this.pointUseRegDate = pointUseRegDate;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getSavePointNum() {
		return savePointNum;
	}
	public void setSavePointNum(String savePointNum) {
		this.savePointNum = savePointNum;
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
	public String getSavePointCharge() {
		return savePointCharge;
	}
	public void setSavePointCharge(String savePointCharge) {
		this.savePointCharge = savePointCharge;
	}
	public String getSavePointRegDate() {
		return savePointRegDate;
	}
	public void setSavePointRegDate(String savePointRegDate) {
		this.savePointRegDate = savePointRegDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + finalPoint;
		result = prime * result + ((mId == null) ? 0 : mId.hashCode());
		result = prime * result + ((pointNum == null) ? 0 : pointNum.hashCode());
		result = prime * result + ((pointRegDate == null) ? 0 : pointRegDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (finalPoint != other.finalPoint)
			return false;
		if (mId == null) {
			if (other.mId != null)
				return false;
		} else if (!mId.equals(other.mId))
			return false;
		if (pointNum == null) {
			if (other.pointNum != null)
				return false;
		} else if (!pointNum.equals(other.pointNum))
			return false;
		if (pointRegDate == null) {
			if (other.pointRegDate != null)
				return false;
		} else if (!pointRegDate.equals(other.pointRegDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Point [pointNum=" + pointNum + ", mId=" + mId + ", finalPoint=" + finalPoint + ", pointRegDate="
				+ pointRegDate + ", pointUseNum=" + pointUseNum + ", gNum=" + gNum + ", pointUseUsed=" + pointUseUsed
				+ ", pointUseRegDate=" + pointUseRegDate + ", goods=" + goods + ", savePointNum=" + savePointNum
				+ ", savePointCause=" + savePointCause + ", savePointDetail=" + savePointDetail + ", savePointCharge="
				+ savePointCharge + ", savePointRegDate=" + savePointRegDate + "]";
	}
	
}
