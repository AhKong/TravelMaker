package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	@Autowired MemberMapper memberMapper;
	
	public Member findMember(String mName, String mTel, String mEmail) {
		return memberMapper.findId(mName, mTel, mEmail);
	}
}
