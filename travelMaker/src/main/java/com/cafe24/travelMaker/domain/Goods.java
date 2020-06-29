package com.cafe24.travelMaker.domain;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
	private String goodsBuyCode;
	private String goodsCode;
	private String memberId;
	private MultipartFile file = null;
	private String goodsPhoto;
	private String goodsCate;
	private String goodsName;
	private String goodsPrice;
	private String goodsDetail;
	private String goodsRegDate;
	private String goodsSaleYesNo;
	private String goodsAmount;
	private String goodsBuyAmount;
	private String goodsPayPrice;
	private String goodsBuyDate;

	public String getGoodsBuyCode() {
		return goodsBuyCode;
	}
	public void setGoodsBuyCode(String goodsBuyCode) {
		this.goodsBuyCode = goodsBuyCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getGoodsPhoto() {
		return goodsPhoto;
	}
	public void setGoodsPhoto(String goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}
	public String getGoodsCate() {
		return goodsCate;
	}
	public void setGoodsCate(String goodsCate) {
		this.goodsCate = goodsCate;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
	public String getGoodsRegDate() {
		return goodsRegDate;
	}
	public void setGoodsRegDate(String goodsRegDate) {
		this.goodsRegDate = goodsRegDate;
	}
	public String getGoodsSaleYesNo() {
		return goodsSaleYesNo;
	}
	public void setGoodsSaleYesNo(String goodsSaleYesNo) {
		this.goodsSaleYesNo = goodsSaleYesNo;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public String getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(String goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	public String getGoodsBuyAmount() {
		return goodsBuyAmount;
	}
	public void setGoodsBuyAmount(String goodsBuyAmount) {
		this.goodsBuyAmount = goodsBuyAmount;
	}
	public String getGoodsPayPrice() {
		return goodsPayPrice;
	}
	public void setGoodsPayPrice(String goodsPayPrice) {
		this.goodsPayPrice = goodsPayPrice;
	}
	public String getGoodsBuyDate() {
		return goodsBuyDate;
	}
	public void setGoodsBuyDate(String goodsBuyDate) {
		this.goodsBuyDate = goodsBuyDate;
	}
	@Override
	public String toString() {
		return "Goods [goodsBuyCode=" + goodsBuyCode + ", goodsCode=" + goodsCode + ", memberId=" + memberId + ", file="
				+ file + ", goodsPhoto=" + goodsPhoto + ", goodsCate=" + goodsCate + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsDetail=" + goodsDetail + ", goodsRegDate=" + goodsRegDate
				+ ", goodsSaleYesNo=" + goodsSaleYesNo + ", goodsAmount=" + goodsAmount + ", goodsBuyAmount="
				+ goodsBuyAmount + ", goodsPayPrice=" + goodsPayPrice + ", goodsBuyDate=" + goodsBuyDate + "]";
	}
}

