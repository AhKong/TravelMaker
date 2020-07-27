package com.cafe24.travelMaker.domain;

public class TripMemo {

	private String tripMemoNum;
	private String mId;
	private String tripNum;
	private String tripName;
	private String tripMemoTripdate;
	private String tripMemoWeather;
	private String tripMemoTitle;
	private String tripMemoContents;
	private String tripMemoPhoto;
	private String tripMemoRegDate;
	private String tripMemoCheck;
	private MyTrip myTrip;
	
	public String getTripMemoNum() {
		return tripMemoNum;
	}
	public void setTripMemoNum(String tripMemoNum) {
		this.tripMemoNum = tripMemoNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getTripNum() {
		return tripNum;
	}
	public void setTripNum(String tripNum) {
		this.tripNum = tripNum;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public String getTripMemoTripdate() {
		return tripMemoTripdate;
	}
	public void setTripMemoTripdate(String tripMemoTripdate) {
		this.tripMemoTripdate = tripMemoTripdate;
	}
	public String getTripMemoWeather() {
		return tripMemoWeather;
	}
	public void setTripMemoWeather(String tripMemoWeather) {
		this.tripMemoWeather = tripMemoWeather;
	}
	public String getTripMemoTitle() {
		return tripMemoTitle;
	}
	public void setTripMemoTitle(String tripMemoTitle) {
		this.tripMemoTitle = tripMemoTitle;
	}
	public String getTripMemoContents() {
		return tripMemoContents;
	}
	public void setTripMemoContents(String tripMemoContents) {
		this.tripMemoContents = tripMemoContents;
	}
	public String getTripMemoPhoto() {
		return tripMemoPhoto;
	}
	public void setTripMemoPhoto(String tripMemoPhoto) {
		this.tripMemoPhoto = tripMemoPhoto;
	}
	public String getTripMemoRegDate() {
		return tripMemoRegDate;
	}
	public void setTripMemoRegDate(String tripMemoRegDate) {
		this.tripMemoRegDate = tripMemoRegDate;
	}
	public String getTripMemoCheck() {
		return tripMemoCheck;
	}
	public void setTripMemoCheck(String tripMemoCheck) {
		this.tripMemoCheck = tripMemoCheck;
	}
	public MyTrip getMyTrip() {
		return myTrip;
	}
	public void setMyTrip(MyTrip myTrip) {
		this.myTrip = myTrip;
	}
	
	@Override
	public String toString() {
		return "TripMemo [tripMemoNum=" + tripMemoNum + ", mId=" + mId + ", tripNum=" + tripNum + ", tripName="
				+ tripName + ", tripMemoTripdate=" + tripMemoTripdate + ", tripMemoWeather=" + tripMemoWeather
				+ ", tripMemoTitle=" + tripMemoTitle + ", tripMemoContents=" + tripMemoContents + ", tripMemoPhoto="
				+ tripMemoPhoto + ", tripMemoRegDate=" + tripMemoRegDate + ", tripMemoCheck=" + tripMemoCheck
				+ ", myTrip=" + myTrip + "]";
	}
	
}
