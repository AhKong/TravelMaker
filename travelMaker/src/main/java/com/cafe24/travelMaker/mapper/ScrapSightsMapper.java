package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.SightsScrap;

@Mapper
public interface ScrapSightsMapper {
	
	public SightsScrap sSelect(SightsScrap sightsScrap); //스크랩 여부 판단하기위한 검색
	public SightsScrap sInsertScrap(SightsScrap sightsScrap); //관광지 스크랩 추가
	public SightsScrap sDeleteScrap(SightsScrap sightsScrap); //관광지 스크랩 삭제
	
}
