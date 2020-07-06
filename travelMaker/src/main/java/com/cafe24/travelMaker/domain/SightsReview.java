package com.cafe24.travelMaker.domain;

import org.springframework.web.multipart.MultipartFile;

public class SightsReview {
	private String sightsReviewNum;
	private Member member;
	private String sightsNum;
	private String sightsReviewTitle;
	private String sightsReviewContents;
	private String sightsReviewGrade;
	private MultipartFile file;
	private String sightsReviewPhoto;
	private String sightsReveiwRegDate;
	private String sightsReveiwUpdateDate;
	private String sightsVisitDate;
	private TripType tripType;
	private boolean isLiked = false;
	public String getSightsReviewNum() {
		return sightsReviewNum;
	}
	public void setSightsReviewNum(String sightsReviewNum) {
		this.sightsReviewNum = sightsReviewNum;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getSightsNum() {
		return sightsNum;
	}
	public void setSightsNum(String sightsNum) {
		this.sightsNum = sightsNum;
	}
	public String getSightsReviewTitle() {
		return sightsReviewTitle;
	}
	public void setSightsReviewTitle(String sightsReviewTitle) {
		this.sightsReviewTitle = sightsReviewTitle;
	}
	public String getSightsReviewContents() {
		return sightsReviewContents;
	}
	public void setSightsReviewContents(String sightsReviewContents) {
		this.sightsReviewContents = sightsReviewContents;
	}
	public String getSightsReviewGrade() {
		return sightsReviewGrade;
	}
	public void setSightsReviewGrade(String sightsReviewGrade) {
		this.sightsReviewGrade = sightsReviewGrade;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getSightsReviewPhoto() {
		return sightsReviewPhoto;
	}
	public void setSightsReviewPhoto(String sightsReviewPhoto) {
		this.sightsReviewPhoto = sightsReviewPhoto;
	}
	public String getSightsReveiwRegDate() {
		return sightsReveiwRegDate;
	}
	public void setSightsReveiwRegDate(String sightsReveiwRegDate) {
		this.sightsReveiwRegDate = sightsReveiwRegDate;
	}
	public String getSightsReveiwUpdateDate() {
		return sightsReveiwUpdateDate;
	}
	public void setSightsReveiwUpdateDate(String sightsReveiwUpdateDate) {
		this.sightsReveiwUpdateDate = sightsReveiwUpdateDate;
	}
	public String getSightsVisitDate() {
		return sightsVisitDate;
	}
	public void setSightsVisitDate(String sightsVisitDate) {
		this.sightsVisitDate = sightsVisitDate;
	}
	public TripType getTripType() {
		return tripType;
	}
	public void setTripType(TripType tripType) {
		this.tripType = tripType;
	}
	public boolean getIsLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	@Override
	public String toString() {
		return "SightsReview [sightsReviewNum=" + sightsReviewNum + ", member=" + member + ", sightsNum=" + sightsNum
				+ ", sightsReviewTitle=" + sightsReviewTitle + ", sightsReviewContents=" + sightsReviewContents
				+ ", sightsReviewGrade=" + sightsReviewGrade + ", file=" + file + ", sightsReviewPhoto="
				+ sightsReviewPhoto + ", sightsReveiwRegDate=" + sightsReveiwRegDate + ", sightsReveiwUpdateDate="
				+ sightsReveiwUpdateDate + ", sightsVisitDate=" + sightsVisitDate + ", tripType=" + tripType
				+ ", isLiked=" + isLiked + "]";
	}
	
	
}
