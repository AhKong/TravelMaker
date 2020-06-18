package com.cafe24.travelMaker.domain;

public class Question {
	private String questionCode;
	private String memberId;
	private String qCate;
	private String qName;
	private String qContents;
	private String qDate;
	public String getQuestionCode() {
		return questionCode;
	}
	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getqCate() {
		return qCate;
	}
	public void setqCate(String qCate) {
		this.qCate = qCate;
	}
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	public String getqContents() {
		return qContents;
	}
	public void setqContents(String qContents) {
		this.qContents = qContents;
	}
	public String getqDate() {
		return qDate;
	}
	public void setqDate(String qDate) {
		this.qDate = qDate;
	}
	@Override
	public String toString() {
		return "Question [questionCode=" + questionCode + ", memberId=" + memberId + ", qCate=" + qCate + ", qName="
				+ qName + ", qContents=" + qContents + ", qDate=" + qDate + "]";
	}
}

