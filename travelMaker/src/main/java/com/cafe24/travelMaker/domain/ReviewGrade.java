package com.cafe24.travelMaker.domain;

public class ReviewGrade {
	private String grade;
	private int gradeCnt;

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getGradeCnt() {
		return gradeCnt;
	}


	public void setGradeCnt(int gradeCnt) {
		this.gradeCnt = gradeCnt;
	}

	@Override
	public String toString() {
		return "ReviewGrade [grade=" + grade + ", gradeCnt=" + gradeCnt + "]";
	}
	
	
	
}
