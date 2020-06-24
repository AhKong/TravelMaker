package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.domain.Member;

@Mapper
public interface GoodsMapper {
	
	public List<Member> getGoodsResultList();
	public Goods getGoodsInfo(String gCode);
	public List<Goods> getMyGoodsList(String mId);
	public int addGoods(Goods goods);
}
