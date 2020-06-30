package com.cafe24.travelMaker.domain;

public class MyTrip {

	private String tNum;
	private String m_id;
	private String tName;
	private String oCheck;
	private String tUrl;
	private String sDate;
	private String eDate;
	private String status;
	private String rDate;
	public String gettNum() {
		return tNum;
	}
	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getoCheck() {
		return oCheck;
	}
	public void setoCheck(String oCheck) {
		this.oCheck = oCheck;
	}
	public String gettUrl() {
		return tUrl;
	}
	public void settUrl(String tUrl) {
		this.tUrl = tUrl;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	@Override
	public String toString() {
		return "MyTrip [tNum=" + tNum + ", m_id=" + m_id + ", tName=" + tName + ", oCheck=" + oCheck + ", tUrl=" + tUrl
				+ ", sDate=" + sDate + ", eDate=" + eDate + ", status=" + status + ", rDate=" + rDate + "]";
	}
	
}
