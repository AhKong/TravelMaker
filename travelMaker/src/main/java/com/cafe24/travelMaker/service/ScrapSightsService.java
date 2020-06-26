package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ResScrap;
import com.cafe24.travelMaker.domain.SightsScrap;
import com.cafe24.travelMaker.mapper.ScrapSightsMapper;
@Service
public class ScrapSightsService {

	@Autowired ScrapSightsMapper scrapMapper;
	public SightsScrap sInsertScrap(SightsScrap sInsertScrap) { //관광지 스크랩 추가
		return scrapMapper.sInsertScrap(sInsertScrap);
	};
	
	public SightsScrap sDeleteScrap(SightsScrap sDeleteScrap) { //관광지 스크랩 삭제
		return scrapMapper.sDeleteScrap(sDeleteScrap);
	}
	
}
