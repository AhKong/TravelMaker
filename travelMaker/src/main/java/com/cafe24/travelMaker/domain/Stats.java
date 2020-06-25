package com.cafe24.travelMaker.domain;

public class Stats {
	//관광명소 통계 
	private String m_gender;
	private String sig_review;
	private String sig_like;
	private String sig_comment;
	private String sig_traffic;
	private String sig_satis;
	private String sig_amenity;
	//음식점 통계
	private String res_review;
	private String res_taste;
	private String res__hygiene;
	private String res_mood;
	private String res_kind;
	private String res_cheap;
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public String getSig_review() {
		return sig_review;
	}
	public void setSig_review(String sig_review) {
		this.sig_review = sig_review;
	}
	public String getSig_like() {
		return sig_like;
	}
	public void setSig_like(String sig_like) {
		this.sig_like = sig_like;
	}
	public String getSig_comment() {
		return sig_comment;
	}
	public void setSig_comment(String sig_comment) {
		this.sig_comment = sig_comment;
	}
	public String getSig_traffic() {
		return sig_traffic;
	}
	public void setSig_traffic(String sig_traffic) {
		this.sig_traffic = sig_traffic;
	}
	public String getSig_satis() {
		return sig_satis;
	}
	public void setSig_satis(String sig_satis) {
		this.sig_satis = sig_satis;
	}
	public String getSig_amenity() {
		return sig_amenity;
	}
	public void setSig_amenity(String sig_amenity) {
		this.sig_amenity = sig_amenity;
	}
	public String getRes_review() {
		return res_review;
	}
	public void setRes_review(String res_review) {
		this.res_review = res_review;
	}
	public String getRes_taste() {
		return res_taste;
	}
	public void setRes_taste(String res_taste) {
		this.res_taste = res_taste;
	}
	public String getRes__hygiene() {
		return res__hygiene;
	}
	public void setRes__hygiene(String res__hygiene) {
		this.res__hygiene = res__hygiene;
	}
	public String getRes_mood() {
		return res_mood;
	}
	public void setRes_mood(String res_mood) {
		this.res_mood = res_mood;
	}
	public String getRes_kind() {
		return res_kind;
	}
	public void setRes_kind(String res_kind) {
		this.res_kind = res_kind;
	}
	public String getRes_cheap() {
		return res_cheap;
	}
	public void setRes_cheap(String res_cheap) {
		this.res_cheap = res_cheap;
	}
	@Override
	public String toString() {
		return "Stats [m_gender=" + m_gender + ", sig_review=" + sig_review + ", sig_like=" + sig_like
				+ ", sig_comment=" + sig_comment + ", sig_traffic=" + sig_traffic + ", sig_satis=" + sig_satis
				+ ", sig_amenity=" + sig_amenity + ", res_review=" + res_review + ", res_taste=" + res_taste
				+ ", res__hygiene=" + res__hygiene + ", res_mood=" + res_mood + ", res_kind=" + res_kind
				+ ", res_cheap=" + res_cheap + "]";
	}
	
}
