package com.cafe24.travelMaker.domain;

import java.util.List;

public class Member {
	private String mId;
	private String mPw;
	private String mLevel;
	private String mName;
	private String mEmail;
	private String mTel;
	private String mGender;
	private String mBirth;
	private String mAddr;
	private String mRegDate;
	private String mAvatar;
	private String mIntrod;
	private List<Goods> goodsList;
	
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	private int mFollow;
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmLevel() {
		return mLevel;
	}
	public void setmLevel(String mLevel) {
		this.mLevel = mLevel;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmTel() {
		return mTel;
	}
	public void setmTel(String mTel) {
		this.mTel = mTel;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
	public String getmBirth() {
		return mBirth;
	}
	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	public String getmAddr() {
		return mAddr;
	}
	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}
	public String getmRegDate() {
		return mRegDate;
	}
	public void setmRegDate(String mRegDate) {
		this.mRegDate = mRegDate;
	}
	public String getmAvatar() {
		return mAvatar;
	}
	public void setmAvatar(String mAvatar) {
		this.mAvatar = mAvatar;
	}
	public String getmIntrod() {
		return mIntrod;
	}
	public void setmIntrod(String mIntrod) {
		this.mIntrod = mIntrod;
	}
	public int getmFollow() {
		return mFollow;
	}
	public void setmFollow(int mFollow) {
		this.mFollow = mFollow;
	}
	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPw=" + mPw + ", mLevel=" + mLevel + ", mName=" + mName + ", mEmail=" + mEmail
				+ ", mTel=" + mTel + ", mGender=" + mGender + ", mBirth=" + mBirth + ", mAddr=" + mAddr + ", mRegDate="
				+ mRegDate + ", mAvatar=" + mAvatar + ", mIntrod=" + mIntrod + ", goodsList=" + goodsList + ", mFollow="
				+ mFollow + "]";
	}
}