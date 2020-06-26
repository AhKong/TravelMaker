package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.SightsScrap;

@Mapper
public interface ScrapSightsMapper {
	
	public SightsScrap sInsertScrap(SightsScrap sInsertScrap); //관광지 스크랩 추가
	public SightsScrap sDeleteScrap(SightsScrap sDeleteScrap); //관광지 스크랩 삭제
	
}
