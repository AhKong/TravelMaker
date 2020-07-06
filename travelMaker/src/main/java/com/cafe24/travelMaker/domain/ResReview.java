package com.cafe24.travelMaker.domain;

import org.springframework.web.multipart.MultipartFile;

public class ResReview {
	private String resReviewNum;
	private Member member;
	private String resNum;
	private String resReviewTitle;
	private String resReviewContents;
	private String resReviewGrade;
	private MultipartFile file;
	private String resReviewPhoto;
	private String resReveiwRegDate;
	private String resReveiwUpdateDate;
	private String resVisitDate;
	private TripType tripType;
	private boolean isLiked = false;
	
	
	public String getResReviewNum() {
		return resReviewNum;
	}
	public void setResReviewNum(String resReviewNum) {
		this.resReviewNum = resReviewNum;
	}

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
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
	
	public TripType getTripType() {
		return tripType;
	}
	public void setTripType(TripType tripType) {
		this.tripType = tripType;
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
	
	public boolean getIsLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	@Override
	public String toString() {
		return "ResReview [resReviewNum=" + resReviewNum + ", member=" + member + ", resNum=" + resNum
				+ ", resReviewTitle=" + resReviewTitle + ", resReviewContents=" + resReviewContents
				+ ", resReviewGrade=" + resReviewGrade + ", file=" + file + ", resReviewPhoto=" + resReviewPhoto
				+ ", resReveiwRegDate=" + resReveiwRegDate + ", resReveiwUpdateDate=" + resReveiwUpdateDate
				+ ", resVisitDate=" + resVisitDate + ", tripType=" + tripType + ", isLiked=" + isLiked + "]";
	}

}