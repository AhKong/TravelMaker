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
import com.cafe24.travelMaker.service.GoodsService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
@RequestMapping("/goods")
public class GoodsController{
	
	@Autowired private GoodsService goodsService;
	@Autowired private StorageService storageService;

	@GetMapping("/buyGoods")
	public String buyGoods(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "/goods/buyGoods";
	}
	@GetMapping("/detailGoods")
	public String detailGoods(Model model, Goods goods, @RequestParam(name="gCode",required=false) String gCode) {
		goods = goodsService.getGoodsInfo(gCode);
		model.addAttribute("goods", goods);
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
	
	
}

