package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Res;
import com.cafe24.travelMaker.domain.ResCate;
import com.cafe24.travelMaker.mapper.ResMapper;

@Service
public class ResService {
	
	@Autowired private ResMapper resMapper;
	public List<ResCate> selectResCate(){
		return resMapper.selectResCate();
	}
	
	public int addRes(Res res) {
		return resMapper.addRes(res);
	}

}
