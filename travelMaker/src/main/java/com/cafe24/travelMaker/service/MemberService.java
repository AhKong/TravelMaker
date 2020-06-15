package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.mapper.MemberMapper;

public class MemberService {
	
	@Autowired private MemberMapper memberMapper;
	
	/*
	 * public Member findId(String mName, String mTel, String mEmail) { return
	 * memberMapper.findId(mName, mTel, mEmail);
	 * 
	 * }
	 */
}
