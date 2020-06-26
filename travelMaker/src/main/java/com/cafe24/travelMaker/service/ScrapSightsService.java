package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.SightsScrap;
import com.cafe24.travelMaker.mapper.ScrapSightsMapper;
@Service
public class ScrapSightsService {

	@Autowired public ScrapSightsMapper scrapMapper;
	
	public SightsScrap sInsertScrap(SightsScrap sightsScrap) { //관광지 스크랩 추가
		return scrapMapper.sInsertScrap(sightsScrap);
	};
	
	public SightsScrap sDeleteScrap(SightsScrap sightsScrap) { //관광지 스크랩 삭제
		return scrapMapper.sDeleteScrap(sightsScrap);
	}
	public SightsScrap sSelect(SightsScrap sightsScrap) { //스크랩 여부 판단하기위한 검색
		System.out.println(sightsScrap + "<----- 스크랩셀렉서비스");
		return scrapMapper.sSelect(sightsScrap);
	}
	
}
