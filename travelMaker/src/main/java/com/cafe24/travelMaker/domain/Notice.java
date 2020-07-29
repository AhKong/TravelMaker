package com.cafe24.travelMaker.domain;

public class Notice {
	private String noticeNum;
	private String mId;
	private String noticeContents;
	private String noticeSendTime;
	private String noticeCheck;
	private String noticeReadTime;
	public String getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public String getNoticeSendTime() {
		return noticeSendTime;
	}
	public void setNoticeSendTime(String noticeSendTime) {
		this.noticeSendTime = noticeSendTime;
	}
	public String getNoticeCheck() {
		return noticeCheck;
	}
	public void setNoticeCheck(String noticeCheck) {
		this.noticeCheck = noticeCheck;
	}
	public String getNoticeReadTime() {
		return noticeReadTime;
	}
	public void setNoticeReadTime(String noticeReadTime) {
		this.noticeReadTime = noticeReadTime;
	}
	@Override
	public String toString() {
		return "Notice [noticeNum=" + noticeNum + ", mId=" + mId + ", noticeContents=" + noticeContents
				+ ", noticeSendTime=" + noticeSendTime + ", noticeCheck=" + noticeCheck + ", noticeReadTime="
				+ noticeReadTime + "]";
	}
}
