package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired public MemberMapper memberMapper;
	
	public Member findId(Member member) { //아이디 찾기
		System.out.println(member +" <----------Service findId");
	return memberMapper.findId(member);  
	}
	
	public Member findPw(Member member) { // 비밀번호 찾기
		System.out.println(member + " <---------- Service findPw");	
	return memberMapper.findPw(member);
	}

}
