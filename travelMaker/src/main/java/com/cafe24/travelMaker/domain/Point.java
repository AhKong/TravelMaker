package com.cafe24.travelMaker.domain;
// 포인트 관리내역  DTO
public class Point {
	private String pointNum;
	private String mId;
	private int finalPoint;
	private String pointRegDate;
	private Goods goods;
	
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
				+ pointRegDate + "]";
	}
	
	
}
