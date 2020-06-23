package com.cafe24.travelMaker.domain;

import java.util.List;

public class SightsFeedback {

	private String sightsFbNum;
	private String sightsFbContents;
	private String sightsFbRegDate;
	private String sightsFbCheck;
	private Member member;
	private List<Sights> sights;
	private FbCode fbcode;
	
	public String getSightsFbNum() {
		return sightsFbNum;
	}
	public void setSightsFbNum(String sightsFbNum) {
		this.sightsFbNum = sightsFbNum;
	}
	public String getSightsFbContents() {
		return sightsFbContents;
	}
	public void setSightsFbContents(String sightsFbContents) {
		this.sightsFbContents = sightsFbContents;
	}
	public String getSightsFbRegDate() {
		return sightsFbRegDate;
	}
	public void setSightsFbRegDate(String sightsFbRegDate) {
		this.sightsFbRegDate = sightsFbRegDate;
	}
	public String getSightsFbCheck() {
		return sightsFbCheck;
	}
	public void setSightsFbCheck(String sightsFbCheck) {
		this.sightsFbCheck = sightsFbCheck;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Sights> getSights() {
		return sights;
	}
	public void setSights(List<Sights> sights) {
		this.sights = sights;
	}
	public FbCode getFbcode() {
		return fbcode;
	}
	public void setFbcode(FbCode fbcode) {
		this.fbcode = fbcode;
	}
	
	
}
