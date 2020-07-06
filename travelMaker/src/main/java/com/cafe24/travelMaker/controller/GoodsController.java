package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.domain.Point;
import com.cafe24.travelMaker.service.GoodsService;
import com.cafe24.travelMaker.service.PointService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
@RequestMapping("/goods")
public class GoodsController{
	
	@Autowired private PointService pointService;
	@Autowired private GoodsService goodsService;
	@Autowired private StorageService storageService;

	@GetMapping("/buyGoods")
	public String buyGoods(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "/goods/buyGoods";
	}
	@GetMapping("/detailGoods")
	public String detailGoods(Model model, Goods goods, Point point, @RequestParam(name="gCode",required=false) String gCode, HttpSession session) {

		goods = goodsService.getGoodsInfo(gCode);
		model.addAttribute("goods", goods);
	
		String loginId = (String)session.getAttribute("SID");
		point = pointService.getPointInfo(loginId);
		model.addAttribute("point", point);
		return "/goods/detailGoods";
	}
	@GetMapping("/detailGoodsAllience")
	public String detailGoodsAllience(Model model, Goods goods, @RequestParam(name="gCode",required=false) String gCode) {
		goods = goodsService.getGoodsInfo(gCode);
		model.addAttribute("goods", goods);
		return "/goods/detailGoodsAllience";
	}
	@GetMapping("/addGoods")
	public String addGoods() {
		return "/goods/addGoods";
	}
	@PostMapping("/addGoods")
	public String addGoods(Goods goods) {
		goods.setGoodsPhoto(goods.getFile().getOriginalFilename());
		if(!"".equals(goods.getGoodsPhoto())) {
			storageService.store(goods.getFile());
		}
		int result = goodsService.addGoods(goods);
		return "redirect:/goods/myRegGoods";
	}
	
	@GetMapping("/myRegGoods")
	public String myRegGoods(Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("SID");
		List<Goods> goodsList = goodsService.getMyGoodsList(loginId);
		model.addAttribute("goodsList", goodsList);
		return "/goods/myRegGoods";
	}
	
	@GetMapping("/deleteGoods")
	public String deleteGoods(@RequestParam(name="gCode", required=false) String gCode) {
		goodsService.deleteGoods(gCode);
		return "redirect:/goods/myRegGoods";
	}
	
	@GetMapping("/goodsModify")
	public String goodsModify(Goods goods,
		@RequestParam(name = "gCode", required = false) String gCode,
		@RequestParam(name = "goodsName", required = false) String goodsName,
		@RequestParam(name = "goodsDescription", required = false) String goodsDescription,
		@RequestParam(name = "selectCate", required = false) String selectCate,
		@RequestParam(name = "goodsAmount", required = false) String goodsAmount,
		@RequestParam(name = "goodsPrice", required = false) String goodsPrice) {
			System.out.println(gCode + "<<<<<<<<<<<<<<<<<<");
			System.out.println(goodsName + "<<<<<<<<<<<<<<<<<<");
			System.out.println(goodsDescription + "<<<<<<<<<<<<<<<<<<");
			System.out.println(selectCate + "<<<<<<<<<<<<<<<<<<");
			System.out.println(goodsAmount + "<<<<<<<<<<<<<<<<<<");
			System.out.println(goodsPrice + "<<<<<<<<<<<<<<<<<<");
			goods.setGoodsCode(gCode);
			goods.setGoodsName(goodsName);
			goods.setGoodsDetail(goodsDescription);
			goods.setGoodsCate(selectCate);
			goods.setGoodsAmount(goodsAmount);
			goods.setGoodsPrice(goodsPrice);
			goodsService.goodsModify(goods);
			return "redirect:/goods/myRegGoods";
		}
	@GetMapping("/goodsBuy")
	public String buyGoods(Goods goods, HttpSession session,
			@RequestParam(name = "gCode", required = false) String gCode,
			@RequestParam(name = "goodsName", required = false) String goodsName,
			@RequestParam(name = "selectCate", required = false) String selectCate,
			@RequestParam(name = "goodsPhoto", required = false) String goodsPhoto,
			@RequestParam(name = "buyAmount", required = false) String buyAmount,
			@RequestParam(name = "payPrice", required = false) String payPrice,
			@RequestParam(name = "goodsNum", required = false) String goodsNum) {
				String loginId = (String)session.getAttribute("SID");
				goods.setMemberId(loginId);
				goods.setGoodsCode(gCode);
				goods.setGoodsName(goodsName);
				goods.setGoodsCate(selectCate);
				goods.setGoodsPhoto(goodsPhoto);
				goods.setGoodsBuyAmount(buyAmount);
				goods.setGoodsPayPrice(payPrice);
				goods.setGoodsCode(goodsNum);
				goodsService.goodsBuy(goods);
				goodsService.updateGoodsAmount(goods);
				pointService.updatePointFinal(goods);
				pointService.pointUseAdmin(goods);
				return "redirect:/goods/buyGoods";
	}
	@GetMapping("/GoodsBuyDelete")
	public String GoodsBuyDelete(Goods goods, HttpSession session,
			@RequestParam(name="goodsBuyAmount", required=false) String goodsBuyAmount,
			@RequestParam(name="goodsBuyCode", required=false) String goodsBuyCode,
			@RequestParam(name = "goodsCode", required = false) String goodsCode,
			@RequestParam(name = "goodsPayPrice", required = false) String goodsPayPrice) {
		String loginId = (String)session.getAttribute("SID");
		goodsService.GoodsBuyDelete(goodsBuyCode);
		goodsService.deleteGoodsAmount(goodsBuyAmount, goodsCode);
		goodsService.goodsBuyDeletePoint(loginId, goodsPayPrice);
		return "redirect:/member/myPage";
	}
}

