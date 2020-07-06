package com.cafe24.travelMaker.domain;

public class ReviewLike {
	private String likeNum;
	private String mId;
	private String reviewNum;
	private String reviewRegDate;
	private boolean isLiked = false;
	
	public String getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(String likeNum) {
		this.likeNum = likeNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReviewRegDate() {
		return reviewRegDate;
	}
	public void setReviewRegDate(String reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}
	
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	@Override
	public String toString() {
		return "ReviewLike [likeNum=" + likeNum + ", mId=" + mId + ", reviewNum=" + reviewNum + ", reviewRegDate="
				+ reviewRegDate + ", isLiked=" + isLiked + "]";
	}

	
	
	
}
