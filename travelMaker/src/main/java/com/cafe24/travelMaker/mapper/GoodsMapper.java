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
	public int updateGoodsAmount(Goods goods);
	public int getGAmount(Goods goods);
	public int updateYesNo(Goods goods);
	public List<Goods> getMyBuyGoods(String mId);
	public int GoodsBuyDelete(String goodsBuyCode);
	public int deleteGoodsAmount(String goodsBuyAmount, String goodsCode);
	public int goodsBuyDeletePoint(String mId, String goodsPayPrice);
}
