package kr.or.ksmart.Dto;

import java.util.List;

public class KmaListDto {
	private String category;
	private List<KamDto> kamList;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<KamDto> getKamList() {
		return kamList;
	}
	public void setKamList(List<KamDto> kamList) {
		this.kamList = kamList;
	}
	
	@Override
	public String toString() {
		return "KmaListDto [category=" + category + ", kamList=" + kamList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((kamList == null) ? 0 : kamList.hashCode());
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
		KmaListDto other = (KmaListDto) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (kamList == null) {
			if (other.kamList != null)
				return false;
		} else if (!kamList.equals(other.kamList))
			return false;
		return true;
	}
	
}
