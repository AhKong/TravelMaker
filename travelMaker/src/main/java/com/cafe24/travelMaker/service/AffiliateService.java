package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Affiliate;
import com.cafe24.travelMaker.mapper.AffiliateMapper;

@Service
public class AffiliateService {
	@Autowired private AffiliateMapper affiliateMapper;
	
	public int addAffiliate(Affiliate aff) {
		return affiliateMapper.addAffiliate(aff);
	}
	
	public int checkAffId(String affId) {
		return affiliateMapper.checkAffId(affId);
	}
}
