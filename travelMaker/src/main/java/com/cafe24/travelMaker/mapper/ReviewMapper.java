package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.TripType;

@Mapper
public interface ReviewMapper {
	public List<TripType> selectTripTypeList();

}
