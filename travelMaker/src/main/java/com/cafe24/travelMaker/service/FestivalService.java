package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.mapper.FestivalMapper;
import com.cafe24.travelMaker.domain.Festival;

@Service
public class FestivalService {

@Autowired private FestivalMapper festivalMapper;	
	
	//축제 등록 
	public int addFestival(Festival festival) {
		//System.out.println("addFestival FestivalService 도착");
		int result = festivalMapper.addFestival(festival);
		System.out.println(result+" <- result addFestival FestivalService");
		
		return result;
	}
	
	//축제 수정화면 이동 
	public Festival festivalSelect(String fesNum) {
		System.out.println("festivalSelect FestivalService 도착");
		Festival festival = festivalMapper.festivalSelect(fesNum);
		System.out.println(fesNum+" <- fesNum festivalSelect FestivalService");
		System.out.println(festival+" <- festival festivalSelect FestivalService");
		
		return festival;
	}
	
	//축제 수정 
	public int updateFestival(Festival festival) {
		System.out.println("updateFestival FestivalService 도착");
		int result = festivalMapper.updateFestival(festival);
		System.out.println(festival+" <- festival updateFestival FestivalService");
		System.out.println(festival.getFesNum()+" <- getFesNum updateFestival FestivalService");
		System.out.println(result+" <- result updateFestival FestivalService");
		
		return 5;
	}
	
	//축제 리스트
	public List<Festival> getFestivalList(){
		System.out.println("getFestivalList FestivalService 도착");
		
		return festivalMapper.getFestivalList();
	}
	
}
