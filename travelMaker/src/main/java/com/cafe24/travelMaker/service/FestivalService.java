package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cafe24.travelMaker.mapper.FestivalMapper;
import com.cafe24.travelMaker.domain.Festival;

@Service
public class FestivalService {

@Autowired private FestivalMapper festivalmapper;	
	
	public int addFestival(Festival festival) {
		System.out.println("addFestival FestivalService 도착");
		int result = festivalmapper.addFestival(festival);
		
		return result;
	}
	
}
