package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.mapper.FestivalMapper;
import com.cafe24.travelMaker.domain.Festival;

@Service
public class FestivalService {

@Autowired private FestivalMapper festivalmapper;	
	
	public int addFestival(Festival festival) {
		//System.out.println("addFestival FestivalService 도착");
		int result = festivalmapper.addFestival(festival);
		
		return result;
	}
	
	public Festival festivalSelect(String fesNum) {
		System.out.println("festivalSelect FestivalService 도착");
		
		return null;
	}
	
	
	public int updateFestival(Festival festival) {
		System.out.println("updateFestival FestivalService 도착");
		
		return 0;
	}
	
}
