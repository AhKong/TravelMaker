package com.cafe24.travelMaker.domain;

import org.springframework.web.multipart.MultipartFile;

public class Res {
	private String resNum;
	private String siNum;
	private String mId;
	private String resCateNum;
	private String resName;
	private MultipartFile file = null;
	private String resPhoto;
	private String resLat;
	private String resLong;
	private String resAddr;
	private String resPrice;
	private String resTel;
	private String resWeb;
	private String resDetail;
	private String resStartTime;
	private String resCloseTime;
	private String resRegTime;
	private ResCate resCate;
	
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
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
	public String getResCateNum() {
		return resCateNum;
	}
	public void setResCateNum(String resCateNum) {
		this.resCateNum = resCateNum;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getResPhoto() {
		return resPhoto;
	}
	public void setResPhoto(String resPhoto) {
		this.resPhoto = resPhoto;
	}
	public String getResLat() {
		return resLat;
	}
	public void setResLat(String resLat) {
		this.resLat = resLat;
	}
	public String getResLong() {
		return resLong;
	}
	public void setResLong(String resLong) {
		this.resLong = resLong;
	}
	public String getResAddr() {
		return resAddr;
	}
	public void setResAddr(String resAddr) {
		this.resAddr = resAddr;
	}
	public String getResPrice() {
		return resPrice;
	}
	public void setResPrice(String resPrice) {
		this.resPrice = resPrice;
	}
	public String getResTel() {
		return resTel;
	}
	public void setResTel(String resTel) {
		this.resTel = resTel;
	}
	public String getResWeb() {
		return resWeb;
	}
	public void setResWeb(String resWeb) {
		this.resWeb = resWeb;
	}
	public String getResDetail() {
		return resDetail;
	}
	public void setResDetail(String resDetail) {
		this.resDetail = resDetail;
	}
	public String getResStartTime() {
		return resStartTime;
	}
	public void setResStartTime(String resStartTime) {
		this.resStartTime = resStartTime;
	}
	public String getResCloseTime() {
		return resCloseTime;
	}
	public void setResCloseTime(String resCloseTime) {
		this.resCloseTime = resCloseTime;
	}
	public String getResRegTime() {
		return resRegTime;
	}
	public void setResRegTime(String resRegTime) {
		this.resRegTime = resRegTime;
	}
	
	public ResCate getResCate() {
		return resCate;
	}
	public void setResCate(ResCate resCate) {
		this.resCate = resCate;
	}
	@Override
	public String toString() {
		return "Res [resNum=" + resNum + ", siNum=" + siNum + ", mId=" + mId + ", resCateNum=" + resCateNum
				+ ", resName=" + resName + ", file=" + file + ", resPhoto=" + resPhoto + ", resLat=" + resLat
				+ ", resLong=" + resLong + ", resAddr=" + resAddr + ", resPrice=" + resPrice + ", resTel=" + resTel
				+ ", resWeb=" + resWeb + ", resDetail=" + resDetail + ", resStartTime=" + resStartTime
				+ ", resCloseTime=" + resCloseTime + ", resRegTime=" + resRegTime + ", resCate=" + resCate + "]";
	}

}
