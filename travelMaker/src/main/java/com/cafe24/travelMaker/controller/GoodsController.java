package com.cafe24.travelMaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.travelMaker.service.GoodsService;

@Controller
public class GoodsController{
	
	@Autowired private GoodsService goodsService;

	@GetMapping("/buyGoods")
	public String buyGoods(Model model) {
		
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "/goods/buyGoods";
	}
	@GetMapping("/detailGoods")
	public String detailGoods() {
		return "/goods/detailGoods";
	}
	@GetMapping("/detailGoodsAllience")
	public String detailGoodsAllience() {
		return "/goods/detailGoodsAllience";
	}
	@GetMapping("/addGoods")
	public String addGoods() {
		return "/goods/addGoods";
	}
}

