package com.cafe24.travelMaker.domain;

public class Festival {

	private String fesNum;
	private String fesName;
	private String fesPhoto = null;
	private String fesStartDate;
	private String fesEndDate;
	private String fesDetail;
	private String fesWeb;
	private String fesRegDate;
	private String fesState;
	private Member member;
	private Sights sights;
	
	public String getFesNum() {
		return fesNum;
	}
	public void setFesNum(String fesNum) {
		this.fesNum = fesNum;
	}
	public String getFesName() {
		return fesName;
	}
	public void setFesName(String fesName) {
		this.fesName = fesName;
	}
	public String getFesPhoto() {
		return fesPhoto;
	}
	public void setFesPhoto(String fesPhoto) {
		this.fesPhoto = fesPhoto;
	}
	public String getFesStartDate() {
		return fesStartDate;
	}
	public void setFesStartDate(String fesStartDate) {
		this.fesStartDate = fesStartDate;
	}
	public String getFesEndDate() {
		return fesEndDate;
	}
	public void setFesEndDate(String fesEndDate) {
		this.fesEndDate = fesEndDate;
	}
	public String getFesDetail() {
		return fesDetail;
	}
	public void setFesDetail(String fesDetail) {
		this.fesDetail = fesDetail;
	}
	public String getFesWeb() {
		return fesWeb;
	}
	public void setFesWeb(String fesWeb) {
		this.fesWeb = fesWeb;
	}
	public String getFesRegDate() {
		return fesRegDate;
	}
	public void setFesRegDate(String fesRegDate) {
		this.fesRegDate = fesRegDate;
	}
	public String getFesState() {
		return fesState;
	}
	public void setFesState(String fesState) {
		this.fesState = fesState;
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
	
	@Override
	public String toString() {
		return "Festival [fesNum=" + fesNum + ", fesName=" + fesName + ", fesPhoto=" + fesPhoto + ", fesStartDate="
				+ fesStartDate + ", fesEndDate=" + fesEndDate + ", fesDetail=" + fesDetail + ", fesWeb=" + fesWeb
				+ ", fesRegDate=" + fesRegDate + ", fesState=" + fesState + ", member=" + member + ", sights=" + sights
				+ "]";
	}
	
	
}
