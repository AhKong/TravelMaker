package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Sights;
import com.cafe24.travelMaker.mapper.IndexTop3Mapper;

@Service
public class IndexTop3Service {
	@Autowired public IndexTop3Mapper indexTop3Mapper;
	
	public List<Sights> indexTop3(){
		return indexTop3Mapper.indexTop3();
	}
}
