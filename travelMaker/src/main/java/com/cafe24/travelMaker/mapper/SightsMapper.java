package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Do;
import com.cafe24.travelMaker.domain.Si;
import com.cafe24.travelMaker.domain.Sights;
import com.cafe24.travelMaker.domain.SightsCate;

@Mapper
public interface SightsMapper {
	public List<SightsCate> selectSightsCate();
	public List<Do> selectDo();
	public List<Si> selectSi(String doNum);
	public int addSights(Sights sights);

}
