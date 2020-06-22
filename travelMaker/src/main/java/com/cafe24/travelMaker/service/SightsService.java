package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Do;
import com.cafe24.travelMaker.domain.Si;
import com.cafe24.travelMaker.domain.Sights;
import com.cafe24.travelMaker.domain.SightsCate;
import com.cafe24.travelMaker.mapper.SightsMapper;

@Service
public class SightsService {
	
	@Autowired private SightsMapper sightsMapper;
	public List<SightsCate> selectSightsCate(){
		return sightsMapper.selectSightsCate();
	};
	
	public List<Do> selectDo(){
		return sightsMapper.selectDo();
	}
	
	public List<Si> selectSi(String doNum){
		return sightsMapper.selectSi(doNum);
	}
	
	public int addSights(Sights sights) {
		return sightsMapper.addSights(sights);
	}
	
	public List<Sights> selectSightsList(String search){
		return sightsMapper.selectSightsList(search);
	}
}
