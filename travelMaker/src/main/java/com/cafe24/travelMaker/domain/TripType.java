package com.cafe24.travelMaker.domain;

public class TripType {
	private String tripTypeNum;
	private String tripTypeName;
	public String getTripTypeNum() {
		return tripTypeNum;
	}
	public void setTripTypeNum(String tripTypeNum) {
		this.tripTypeNum = tripTypeNum;
	}
	public String getTripTypeName() {
		return tripTypeName;
	}
	public void setTripTypeName(String tripTypeName) {
		this.tripTypeName = tripTypeName;
	}
	@Override
	public String toString() {
		return "TripType [tripTypeNum=" + tripTypeNum + ", tripTypeName=" + tripTypeName + "]";
	}
	
}
