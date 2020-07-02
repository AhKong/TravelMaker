package com.cafe24.travelMaker.domain;

import java.util.List;

public class KmaListDto {
	private String category;
	private List<KamDto> kamList;
	private List<KamDto2> kamList2;
	private List<KamDto3> kamList3;
	
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
	
	public List<KamDto2> getKamList2() {
		return kamList2;
	}
	public void setKamList2(List<KamDto2> kamList2) {
		this.kamList2 = kamList2;
	}
	public List<KamDto3> getKamList3() {
		return kamList3;
	}
	public void setKamList3(List<KamDto3> kamList3) {
		this.kamList3 = kamList3;
	}
	@Override
	public String toString() {
		return "KmaListDto [category=" + category + ", kamList=" + kamList + ", kamList2=" + kamList2 + ", kamList3="
				+ kamList3 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((kamList == null) ? 0 : kamList.hashCode());
		result = prime * result + ((kamList2 == null) ? 0 : kamList2.hashCode());
		result = prime * result + ((kamList3 == null) ? 0 : kamList3.hashCode());
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
		if (kamList2 == null) {
			if (other.kamList2 != null)
				return false;
		} else if (!kamList2.equals(other.kamList2))
			return false;
		if (kamList3 == null) {
			if (other.kamList3 != null)
				return false;
		} else if (!kamList3.equals(other.kamList3))
			return false;
		return true;
	}
}
