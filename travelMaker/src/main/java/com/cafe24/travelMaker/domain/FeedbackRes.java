package com.cafe24.travelMaker.domain;

public class FeedbackRes {

	private String fbResNum;
	private String fbResContents;
	private String fbResRegDate;
	private String fbResCheck;
	private Member member;
	private Res res;
	private FbCode fbCode;
	
	public String getFbResNum() {
		return fbResNum;
	}
	public void setFbResNum(String fbResNum) {
		this.fbResNum = fbResNum;
	}
	public String getFbResContents() {
		return fbResContents;
	}
	public void setFbResContents(String fbResContents) {
		this.fbResContents = fbResContents;
	}
	public String getFbResRegDate() {
		return fbResRegDate;
	}
	public void setFbResRegDate(String fbResRegDate) {
		this.fbResRegDate = fbResRegDate;
	}
	public String getFbResCheck() {
		return fbResCheck;
	}
	public void setFbResCheck(String fbResCheck) {
		this.fbResCheck = fbResCheck;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Res getRes() {
		return res;
	}
	public void setRes(Res res) {
		this.res = res;
	}
	public FbCode getFbCode() {
		return fbCode;
	}
	public void setFbCode(FbCode fbCode) {
		this.fbCode = fbCode;
	}
	
	@Override
	public String toString() {
		return "FeedbackRes [fbResNum=" + fbResNum + ", fbResContents=" + fbResContents + ", fbResRegDate="
				+ fbResRegDate + ", fbResCheck=" + fbResCheck + ", member=" + member + ", res=" + res + ", fbCode="
				+ fbCode + "]";
	}
}
