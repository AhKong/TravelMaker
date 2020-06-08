package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController{
	@GetMapping("/buyGoods")
	public String buyGoods() {
		return "/goods/buyGoods";
	}
}
