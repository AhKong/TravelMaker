package kr.or.ksmart.Dto;

public class KamDto {
	private String hour;
	private String wfkor;
	
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
	
	@Override
	public String toString() {
		return "KamDto [hour=" + hour + ", wfkor=" + wfkor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
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
		KamDto other = (KamDto) obj;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (wfkor == null) {
			if (other.wfkor != null)
				return false;
		} else if (!wfkor.equals(other.wfkor))
			return false;
		return true;
	}
	
}
