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
		System.out.println("addFestival FestivalService 도착");
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
		
		return result;
	}
	
	//축제 상태 업데이트
	public int updateFestivalState() {
		System.out.println("축제 상태 없데이트 할게요!");
		int state = festivalMapper.updateFestivalState();
		System.out.println("축제 상태 없데이트 완료~~~! 업데이트 된 축제 row 개수 -> "+state);
		
		return state;
	}
	
	//축제 리스트 (현재 진행중)
	public List<Festival> ingFestivalList(){
		System.out.println("ingFestivalList FestivalService 도착");
		List<Festival> fList = festivalMapper.ingFestivalList();
		System.out.println(fList+" <- fList ingFestivalList FestivalService");
		
		return fList;
	}
	
	//축제 리스트 (진행 예정)
	public List<Festival> preFestivalList(){
		System.out.println("preFestivalList FestivalService 도착");
		List<Festival> fList = festivalMapper.preFestivalList();
		System.out.println(fList+" <- fList preFestivalList FestivalService");
		
		return fList;
	}
	
	//축제 리스트 (진행 종료)
	public List<Festival> postFestivalList(){
		System.out.println("postFestivalList FestivalService 도착");
		List<Festival> fList = festivalMapper.postFestivalList();
		System.out.println(fList+" <- fList postFestivalList FestivalService");
		
		return fList;
	}
	
	//축제 삭제
	public int deleteFestival(String fesNum) {
		System.out.println("deleteFestival FestivalService 도착");
		System.out.println(fesNum+" <- fesNum deleteFestival FestivalService");
		
		return festivalMapper.deleteFestival(fesNum);
	}
	
}
