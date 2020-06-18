package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.mapper.MemberMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class JoinLoginService {
public  @Autowired  MemberMapper memberMapper;

public int mIdCheck(String mId) {
	return memberMapper.mIdCheck(mId);
}

public Member memberLogin(String mId) {
	return memberMapper.getMemberInfo(mId);
}

public int addMember(Member member) {
	return memberMapper.addMember(member);
}

}
