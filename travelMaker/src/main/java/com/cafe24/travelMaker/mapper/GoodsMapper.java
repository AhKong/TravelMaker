package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Goods;

@Mapper
public interface GoodsMapper {
	
	public List<Goods> getGoodsResultList();
	public Goods getGoodsInfo(String gCode);
	public List<Goods> getMyGoodsList(String mId);
	public int addGoods(Goods goods);
	public int deleteGoods(String gCode);
	public int goodsModify(Goods goods);
	public int goodsBuy(Goods goods);
}
