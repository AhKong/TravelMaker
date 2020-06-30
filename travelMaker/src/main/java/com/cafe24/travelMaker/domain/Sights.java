package com.cafe24.travelMaker.domain;

import org.springframework.web.multipart.MultipartFile;

public class Sights {
	private String sightsNum;
	private String siNum;
	private String mId;
	private String sightsCateNum;
	private String sightsName;
	private MultipartFile file = null;
	private String sightsPhoto;
	private String sightsDetail;
	private String sightsLat; //위도
	private String sightsLong; //경도
	private String sightsAddr;
	private String sightsWeb;
	private String sightsTel;
	private String sightsStartTime;
	private String sightsCloseTime;
	private String sightsRegDate;
	private SightsCate sightsCate;
	private String sightsOpen;
	private String btnColor;
	public String getSightsNum() {
		return sightsNum;
	}
	public void setSightsNum(String sightsNum) {
		this.sightsNum = sightsNum;
	}
	public String getSiNum() {
		return siNum;
	}
	public void setSiNum(String siNum) {
		this.siNum = siNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getSightsCateNum() {
		return sightsCateNum;
	}
	public void setSightsCateNum(String sightsCateNum) {
		this.sightsCateNum = sightsCateNum;
	}
	public String getSightsName() {
		return sightsName;
	}
	public void setSightsName(String sightsName) {
		this.sightsName = sightsName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getSightsPhoto() {
		return sightsPhoto;
	}
	public void setSightsPhoto(String sightsPhoto) {
		this.sightsPhoto = sightsPhoto;
	}
	public String getSightsDetail() {
		return sightsDetail;
	}
	public void setSightsDetail(String sightsDetail) {
		this.sightsDetail = sightsDetail;
	}
	public String getSightsLat() {
		return sightsLat;
	}
	public void setSightsLat(String sightsLat) {
		this.sightsLat = sightsLat;
	}
	public String getSightsLong() {
		return sightsLong;
	}
	public void setSightsLong(String sightsLong) {
		this.sightsLong = sightsLong;
	}
	public String getSightsAddr() {
		return sightsAddr;
	}
	public void setSightsAddr(String sightsAddr) {
		this.sightsAddr = sightsAddr;
	}
	public String getSightsWeb() {
		return sightsWeb;
	}
	public void setSightsWeb(String sightsWeb) {
		this.sightsWeb = sightsWeb;
	}
	public String getSightsTel() {
		return sightsTel;
	}
	public void setSightsTel(String sightsTel) {
		this.sightsTel = sightsTel;
	}
	public String getSightsStartTime() {
		return sightsStartTime;
	}
	public void setSightsStartTime(String sightsStartTime) {
		this.sightsStartTime = sightsStartTime;
	}
	public String getSightsCloseTime() {
		return sightsCloseTime;
	}
	public void setSightsCloseTime(String sightsCloseTime) {
		this.sightsCloseTime = sightsCloseTime;
	}
	public String getSightsRegDate() {
		return sightsRegDate;
	}
	public void setSightsRegDate(String sightsRegDate) {
		this.sightsRegDate = sightsRegDate;
	}
	
	public SightsCate getSightsCate() {
		return sightsCate;
	}
	public void setSightsCate(SightsCate sightsCate) {
		this.sightsCate = sightsCate;
	}
	
	public String getSightsOpen() {
		return sightsOpen;
	}
	public void setSightsOpen(String sightsOpen) {
		this.sightsOpen = sightsOpen;
	}
	
	public String getBtnColor() {
		return btnColor;
	}
	public void setBtnColor(String btnColor) {
		this.btnColor = btnColor;
	}
	@Override
	public String toString() {
		return "Sights [sightsNum=" + sightsNum + ", siNum=" + siNum + ", mId=" + mId + ", sightsCateNum="
				+ sightsCateNum + ", sightsName=" + sightsName + ", file=" + file + ", sightsPhoto=" + sightsPhoto
				+ ", sightsDetail=" + sightsDetail + ", sightsLat=" + sightsLat + ", sightsLong=" + sightsLong
				+ ", sightsAddr=" + sightsAddr + ", sightsWeb=" + sightsWeb + ", sightsTel=" + sightsTel
				+ ", sightsStartTime=" + sightsStartTime + ", sightsCloseTime=" + sightsCloseTime + ", sightsRegDate="
				+ sightsRegDate + ", sightsCate=" + sightsCate + ", sightsOpen=" + sightsOpen + ", btnColor=" + btnColor
				+ "]";
	}
}
