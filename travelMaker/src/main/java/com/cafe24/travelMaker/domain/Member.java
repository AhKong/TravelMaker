package com.cafe24.travelMaker.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile file = null;
	private String mAvatar;
	private String mIntrod;
	private List<Goods> goodsList;
	private int mFollowing;
	private Point point;
	private String dropNum;			//탈퇴회원관리
	private String dropReasonCheck;
	private String dropContents;
	private String dropDate;
	private String mDormantRegDate;	//휴면회원관리
	private String mDormantCanCelDate;
	
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
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
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public int getmFollowing() {
		return mFollowing;
	}
	public void setmFollowing(int mFollowing) {
		this.mFollowing = mFollowing;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public String getDropNum() {
		return dropNum;
	}
	public void setDropNum(String dropNum) {
		this.dropNum = dropNum;
	}
	public String getDropReasonCheck() {
		return dropReasonCheck;
	}
	public void setDropReasonCheck(String dropReasonCheck) {
		this.dropReasonCheck = dropReasonCheck;
	}
	public String getDropContents() {
		return dropContents;
	}
	public void setDropContents(String dropContents) {
		this.dropContents = dropContents;
	}
	public String getDropDate() {
		return dropDate;
	}
	public void setDropDate(String dropDate) {
		this.dropDate = dropDate;
	}
	public String getmDormantRegDate() {
		return mDormantRegDate;
	}
	public void setmDormantRegDate(String mDormantRegDate) {
		this.mDormantRegDate = mDormantRegDate;
	}
	public String getmDormantCanCelDate() {
		return mDormantCanCelDate;
	}
	public void setmDormantCanCelDate(String mDormantCanCelDate) {
		this.mDormantCanCelDate = mDormantCanCelDate;
	}
	
	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPw=" + mPw + ", mLevel=" + mLevel + ", mName=" + mName + ", mEmail=" + mEmail
				+ ", mTel=" + mTel + ", mGender=" + mGender + ", mBirth=" + mBirth + ", mAddr=" + mAddr + ", mRegDate="
				+ mRegDate + ", file=" + file + ", mAvatar=" + mAvatar + ", mIntrod=" + mIntrod + ", goodsList="
				+ goodsList + ", mFollowing=" + mFollowing + ", point=" + point + ", dropNum=" + dropNum
				+ ", dropReasonCheck=" + dropReasonCheck + ", dropContents=" + dropContents + ", dropDate=" + dropDate
				+ ", mDormantRegDate=" + mDormantRegDate + ", mDormantCanCelDate=" + mDormantCanCelDate + "]";
	}
}
