package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.MyTrip;
@Mapper
public interface ScrapModalMapper {

	public List<MyTrip> ModalScarpList(String mId);
}
