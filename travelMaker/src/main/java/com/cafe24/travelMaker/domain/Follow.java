package com.cafe24.travelMaker.domain;

public class Follow {
	private String followNum;
	private String mId;
	private String targetId;
	private Member member;
	public String getFollowNum() {
		return followNum;
	}
	public void setFollowNum(String followNum) {
		this.followNum = followNum;
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Follow [followNum=" + followNum + ", mId=" + mId + ", targetId=" + targetId + ", member=" + member
				+ "]";
	}
}
