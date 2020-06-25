package com.cafe24.travelMaker.domain;

public class Affiliate {
	private String affId;
	private String affPw;
	private String affName;
 	private String affTel;
 	private String affAddr;
 	private String affEmail;
 	private String levelNum;
 	private String affRegDate;
 	private String affActive;
	public String getAffId() {
		return affId;
	}
	public void setAffId(String affId) {
		this.affId = affId;
	}
	public String getAffPw() {
		return affPw;
	}
	public void setAffPw(String affPw) {
		this.affPw = affPw;
	}
	public String getAffName() {
		return affName;
	}
	public void setAffName(String affName) {
		this.affName = affName;
	}
	public String getAffTel() {
		return affTel;
	}
	public void setAffTel(String affTel) {
		this.affTel = affTel;
	}
	public String getAffAddr() {
		return affAddr;
	}
	public void setAffAddr(String affAddr) {
		this.affAddr = affAddr;
	}
	public String getAffEmail() {
		return affEmail;
	}
	public void setAffEmail(String affEmail) {
		this.affEmail = affEmail;
	}
	public String getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
	}
	public String getAffRegDate() {
		return affRegDate;
	}
	public void setAffRegDate(String affRegDate) {
		this.affRegDate = affRegDate;
	}
	public String getAffActive() {
		return affActive;
	}
	public void setAffActive(String affActive) {
		this.affActive = affActive;
	}
	@Override
	public String toString() {
		return "Affiliate [affId=" + affId + ", affPw=" + affPw + ", affName=" + affName + ", affTel=" + affTel
				+ ", affAddr=" + affAddr + ", affEmail=" + affEmail + ", levelNum=" + levelNum + ", affRegDate="
				+ affRegDate + ", affActive=" + affActive + "]";
	}
}
