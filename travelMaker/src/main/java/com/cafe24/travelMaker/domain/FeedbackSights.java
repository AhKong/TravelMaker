package com.cafe24.travelMaker.domain;

public class FeedbackSights {

	private String fbSightsNum;
	private String fbSightsContents;
	private String fbSightsRegDate;
	private String fbSightsCheck;
	private Member member;
	private Sights sights;
	private FbCode fbCode;
	
	public String getFbSightsNum() {
		return fbSightsNum;
	}
	public void setFbSightsNum(String fbSightsNum) {
		this.fbSightsNum = fbSightsNum;
	}
	public String getFbSightsContents() {
		return fbSightsContents;
	}
	public void setFbSightsContents(String fbSightsContents) {
		this.fbSightsContents = fbSightsContents;
	}
	public String getFbSightsRegDate() {
		return fbSightsRegDate;
	}
	public void setFbSightsRegDate(String fbSightsRegDate) {
		this.fbSightsRegDate = fbSightsRegDate;
	}
	public String getFbSightsCheck() {
		return fbSightsCheck;
	}
	public void setFbSightsCheck(String fbSightsCheck) {
		this.fbSightsCheck = fbSightsCheck;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Sights getSights() {
		return sights;
	}
	public void setSights(Sights sights) {
		this.sights = sights;
	}
	public FbCode getFbCode() {
		return fbCode;
	}
	public void setFbCode(FbCode fbCode) {
		this.fbCode = fbCode;
	}
	
	@Override
	public String toString() {
		return "FeedbackSights [fbSightsNum=" + fbSightsNum + ", fbSightsContents=" + fbSightsContents
				+ ", fbSightsRegDate=" + fbSightsRegDate + ", fbSightsCheck=" + fbSightsCheck + ", member=" + member
				+ ", sights=" + sights + ", fbCode=" + fbCode + "]";
	}
	
}
