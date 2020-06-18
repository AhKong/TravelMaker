package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.mapper.MemberMapper;

public class MemberService {
	
	@Autowired public MemberMapper memberMapper;
	
	public Member findId(Member member) { 
	return memberMapper.findId(member);  
	}
	 
}
