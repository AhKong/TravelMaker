package com.cafe24.travelMaker.domain;

public class Message {
	private String messageNum;
	private String mId;
	private String targetId;
	private String contents;
	private String isChecked;
	private String msgSendTime;
	private String msgReadTime;
	public String getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(String messageNum) {
		this.messageNum = messageNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}
	public String getMsgSendTime() {
		return msgSendTime;
	}
	public void setMsgSendTime(String msgSendTime) {
		this.msgSendTime = msgSendTime;
	}
	public String getMsgReadTime() {
		return msgReadTime;
	}
	public void setMsgReadTime(String msgReadTime) {
		this.msgReadTime = msgReadTime;
	}
	@Override
	public String toString() {
		return "Message [messageNum=" + messageNum + ", mId=" + mId + ", targetId=" + targetId + ", contents="
				+ contents + ", isChecked=" + isChecked + ", msgSendTime=" + msgSendTime + ", msgReadTime="
				+ msgReadTime + "]";
	}

}
