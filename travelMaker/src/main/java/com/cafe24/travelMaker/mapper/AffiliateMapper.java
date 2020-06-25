package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Affiliate;

/*
 * 제휴업체 맵퍼 
 * */
@Mapper
public interface AffiliateMapper {

	public int addAffiliate(Affiliate aff);
}
