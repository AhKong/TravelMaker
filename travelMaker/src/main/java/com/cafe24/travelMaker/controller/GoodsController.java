package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController{
	@GetMapping("/buyGoods")
	public String buyGoods() {
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
