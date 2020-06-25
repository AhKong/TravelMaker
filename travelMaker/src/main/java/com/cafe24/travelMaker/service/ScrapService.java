package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ResScrap;
import com.cafe24.travelMaker.domain.SightsScrap;
import com.cafe24.travelMaker.mapper.ScrapMapper;
@Service
public class ScrapService {

	@Autowired ScrapMapper scrapMapper;
	public SightsScrap sInsertScrap(SightsScrap sInsertScrap) { //관광지 스크랩 추가
		return scrapMapper.sInsertScrap(sInsertScrap);
	};
	
	public SightsScrap sDeleteScrap(SightsScrap sDeleteScrap) { //관광지 스크랩 삭제
		return scrapMapper.sDeleteScrap(sDeleteScrap);
	}
	
	public ResScrap rInsertScrap(ResScrap rInsertScrap) { //음식점 스크랩 추가
		return scrapMapper.rInsertScrap(rInsertScrap);
	}
	public ResScrap rDeleteScrap(ResScrap rDeleteScrap) { // 음식점 스크랩 삭제
		return scrapMapper.rDeleteScrap(rDeleteScrap);
	}
	
}
