package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Sights;

@Mapper
public interface IndexTop3Mapper {
	public List<Sights> indexTop3();
}
