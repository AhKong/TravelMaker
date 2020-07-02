package com.cafe24.travelMaker.domain;

public class KamDto2 {
	private String hour;
	private String wfkor;
	private String tmx;
	private String tmn;
	private String pop;
	private String reh;
	private String temp;
	
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getWfkor() {
		return wfkor;
	}
	public void setWfkor(String wfkor) {
		this.wfkor = wfkor;
	}
	
	public String getTmx() {
		return tmx;
	}
	public void setTmx(String tmx) {
		this.tmx = tmx;
	}
	public String getTmn() {
		return tmn;
	}
	public void setTmn(String tmn) {
		this.tmn = tmn;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public String getReh() {
		return reh;
	}
	public void setReh(String reh) {
		this.reh = reh;
	}
	
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	@Override
	public String toString() {
		return "KamDto2 [hour=" + hour + ", wfkor=" + wfkor + ", tmx=" + tmx + ", tmn=" + tmn + ", pop=" + pop
				+ ", reh=" + reh + ", temp=" + temp + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + ((pop == null) ? 0 : pop.hashCode());
		result = prime * result + ((reh == null) ? 0 : reh.hashCode());
		result = prime * result + ((temp == null) ? 0 : temp.hashCode());
		result = prime * result + ((tmn == null) ? 0 : tmn.hashCode());
		result = prime * result + ((tmx == null) ? 0 : tmx.hashCode());
		result = prime * result + ((wfkor == null) ? 0 : wfkor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KamDto2 other = (KamDto2) obj;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (pop == null) {
			if (other.pop != null)
				return false;
		} else if (!pop.equals(other.pop))
			return false;
		if (reh == null) {
			if (other.reh != null)
				return false;
		} else if (!reh.equals(other.reh))
			return false;
		if (temp == null) {
			if (other.temp != null)
				return false;
		} else if (!temp.equals(other.temp))
			return false;
		if (tmn == null) {
			if (other.tmn != null)
				return false;
		} else if (!tmn.equals(other.tmn))
			return false;
		if (tmx == null) {
			if (other.tmx != null)
				return false;
		} else if (!tmx.equals(other.tmx))
			return false;
		if (wfkor == null) {
			if (other.wfkor != null)
				return false;
		} else if (!wfkor.equals(other.wfkor))
			return false;
		return true;
	}
	
	
}
