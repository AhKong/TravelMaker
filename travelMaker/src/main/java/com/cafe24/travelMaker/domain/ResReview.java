package com.cafe24.travelMaker.domain;

import org.springframework.web.multipart.MultipartFile;

public class ResReview {
	private String resReviewNum;
	private String mId;
	private String resNum;
	private String resReviewTitle;
	private String resReviewContents;
	private String resReviewGrade;
	private MultipartFile file;
	private String resReviewPhoto;
	private String resTravelType;
	private String resReveiwRegDate;
	private String resReveiwUpdateDate;
	private String resVisitDate;
	public String getResReviewNum() {
		return resReviewNum;
	}
	public void setResReviewNum(String resReviewNum) {
		this.resReviewNum = resReviewNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
	}
	public String getResReviewTitle() {
		return resReviewTitle;
	}
	public void setResReviewTitle(String resReviewTitle) {
		this.resReviewTitle = resReviewTitle;
	}
	public String getResReviewContents() {
		return resReviewContents;
	}
	public void setResReviewContents(String resReviewContents) {
		this.resReviewContents = resReviewContents;
	}
	public String getResReviewGrade() {
		return resReviewGrade;
	}
	public void setResReviewGrade(String resReviewGrade) {
		this.resReviewGrade = resReviewGrade;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getResReviewPhoto() {
		return resReviewPhoto;
	}
	public void setResReviewPhoto(String resReviewPhoto) {
		this.resReviewPhoto = resReviewPhoto;
	}
	public String getResTravelType() {
		return resTravelType;
	}
	public void setResTravelType(String resTravelType) {
		this.resTravelType = resTravelType;
	}
	public String getResReveiwRegDate() {
		return resReveiwRegDate;
	}
	public void setResReveiwRegDate(String resReveiwRegDate) {
		this.resReveiwRegDate = resReveiwRegDate;
	}
	public String getResReveiwUpdateDate() {
		return resReveiwUpdateDate;
	}
	public void setResReveiwUpdateDate(String resReveiwUpdateDate) {
		this.resReveiwUpdateDate = resReveiwUpdateDate;
	}
	
	public String getResVisitDate() {
		return resVisitDate;
	}
	public void setResVisitDate(String resVisitDate) {
		this.resVisitDate = resVisitDate;
	}
	@Override
	public String toString() {
		return "ResReview [resReviewNum=" + resReviewNum + ", mId=" + mId + ", resNum=" + resNum + ", resReviewTitle="
				+ resReviewTitle + ", resReviewContents=" + resReviewContents + ", resReviewGrade=" + resReviewGrade
				+ ", file=" + file + ", resReviewPhoto=" + resReviewPhoto + ", resTravelType=" + resTravelType
				+ ", resReveiwRegDate=" + resReveiwRegDate + ", resReveiwUpdateDate=" + resReveiwUpdateDate
				+ ", resVisitDate=" + resVisitDate + "]";
	}

	
}
