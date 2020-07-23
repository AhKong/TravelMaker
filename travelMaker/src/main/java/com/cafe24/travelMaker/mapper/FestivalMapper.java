package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Festival;

@Mapper
public interface FestivalMapper {

	
	//축제 등록
	public int addFestival(Festival festival);
	
	//축제 검색 
	public Festival festivalSelect(String fesNum);
	
	//축제 수정
	public int updateFestival(Festival festival);
	
	//축제 상태 업데이트
	public int updateFestivalState();

	//축제 리스트 (현재 진행중)
	public List<Festival> ingFestivalList();
	
	//축제 리스트 (진행 예정)
	public List<Festival> preFestivalList();
	
	//축제 리스트 (진행 종료)
	public List<Festival> postFestivalList();
	
	//축제 삭제
	public int deleteFestival(String fesNum);
	
}
