package com.cafe24.travelMaker.domain;

public class ResReviewComments {
	
	private String commentsNum;
	private Member member;
	private String resReviewNum;
	private String commentsContents;
	private String commentsRegDate;
	public String getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(String commentsNum) {
		this.commentsNum = commentsNum;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getResReviewNum() {
		return resReviewNum;
	}
	public void setResReviewNum(String resReviewNum) {
		this.resReviewNum = resReviewNum;
	}
	public String getCommentsContents() {
		return commentsContents;
	}
	public void setCommentsContents(String commentsContents) {
		this.commentsContents = commentsContents;
	}
	public String getCommentsRegDate() {
		return commentsRegDate;
	}
	public void setCommentsRegDate(String commentsRegDate) {
		this.commentsRegDate = commentsRegDate;
	}
	@Override
	public String toString() {
		return "ResReviewComments [commentsNum=" + commentsNum + ", member=" + member + ", resReviewNum=" + resReviewNum
				+ ", commentsContents=" + commentsContents + ", commentsRegDate=" + commentsRegDate + "]";
	}
	
	
}
