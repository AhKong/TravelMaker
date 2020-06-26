package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ResScrap;
import com.cafe24.travelMaker.domain.SightsScrap;
import com.cafe24.travelMaker.mapper.ScrapResMapper;
import com.cafe24.travelMaker.mapper.ScrapSightsMapper;
@Service
public class ScrapResService {

	@Autowired ScrapResMapper scrapResMapper;
	
	public ResScrap rInsertScrap(ResScrap rInsertScrap) { //음식점 스크랩 추가
		return scrapResMapper.rInsertScrap(rInsertScrap);
	}
	public ResScrap rDeleteScrap(ResScrap rDeleteScrap) { // 음식점 스크랩 삭제
		return scrapResMapper.rDeleteScrap(rDeleteScrap);
	}
	
}
