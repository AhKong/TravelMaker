package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.ResScrap;
import com.cafe24.travelMaker.domain.SightsScrap;

@Mapper
public interface ScrapResMapper {
	
	public ResScrap rInsertScrap(ResScrap rInsertScrap); //음식점 스크랩 추가
	public ResScrap rDeleteScrap(ResScrap rDeleteScrap); //음식점 스크랩 삭제
}
