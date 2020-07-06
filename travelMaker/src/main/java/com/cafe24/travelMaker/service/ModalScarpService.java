package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.MyTrip;
import com.cafe24.travelMaker.mapper.ScrapModalMapper;
@Service
public class ModalScarpService {

	@Autowired public ScrapModalMapper scrapModalMapper;
	public List<MyTrip> ModalScarpList(String mId){
		System.out.println("스크랩모달멮ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ");
		return scrapModalMapper.ModalScarpList(mId);
	}
}
