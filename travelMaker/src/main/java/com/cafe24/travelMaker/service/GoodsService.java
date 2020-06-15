package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	@Autowired private GoodsMapper goodsMapper;
	
	public List<Member> getGoodsList(){
		return goodsMapper.getGoodsResultList();
	}
}
