package com.cafe24.travelMaker.domain;

public class Preference {
	private String type;
	private int count;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Preference [type=" + type + ", count=" + count + "]";
	}
	
	
}
