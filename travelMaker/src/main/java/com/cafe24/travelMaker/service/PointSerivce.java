package com.cafe24.travelMaker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.SavePoint;
import com.cafe24.travelMaker.mapper.PointMapper;
/**
	포인트에 대한 모든 서비스 
*/
@Service

public class PointSerivce {
	@Autowired private PointMapper pointMapper;
	public int addPoint(SavePoint savePoint) {
		return pointMapper.addPoint(savePoint);
	}
	
}
