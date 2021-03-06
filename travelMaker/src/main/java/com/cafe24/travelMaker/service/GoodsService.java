package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	@Autowired private GoodsMapper goodsMapper;
	
	public List<Goods> getGoodsList(){
		return goodsMapper.getGoodsResultList();
	}
	
	public Goods getGoodsInfo(String gCode) {
		return goodsMapper.getGoodsInfo(gCode);
	}
	
	public List<Goods> getMyGoodsList(String mId){
		return goodsMapper.getMyGoodsList(mId);
	}
	
	public int addGoods(Goods goods) {
		return goodsMapper.addGoods(goods);
	}
	
	public int deleteGoods(String gCode) {
		return goodsMapper.deleteGoods(gCode);
	}
	
	public int goodsModify(Goods goods) {
		return goodsMapper.goodsModify(goods);
	}
	
	public int goodsBuy(Goods goods) {
		return goodsMapper.goodsBuy(goods);
	}
	
	public int updateGoodsAmount(Goods goods) {
		int gAmount = goodsMapper.getGAmount(goods);
		int result = 0;
		if(gAmount == Integer.parseInt(goods.getGoodsBuyAmount())) {
			result = goodsMapper.updateGoodsAmount(goods);
			result = goodsMapper.updateYesNo(goods);
		}else {
			result = goodsMapper.updateGoodsAmount(goods);
		}
		return result;
	}
	
	public List<Goods> getMyBuyGoods(String mId){
		return goodsMapper.getMyBuyGoods(mId);
	}
	
	public int GoodsBuyDelete(String goodsBuyCode) {
		
		return goodsMapper.GoodsBuyDelete(goodsBuyCode);
	}
	
	public int deleteGoodsAmount(String goodsBuyAmount, String goodsCode) {
		System.out.println(goodsBuyAmount + "ㅎㅎㅎㅎ" + goodsCode);
		return goodsMapper.deleteGoodsAmount(goodsBuyAmount, goodsCode); 
	}
	
	public int goodsBuyDeletePoint(String mId, String goodsPayPrice) {
		return goodsMapper.goodsBuyDeletePoint(mId, goodsPayPrice);
	}
}
