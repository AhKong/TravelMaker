package com.cafe24.travelMaker.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Member;

@Mapper
public interface MemberMapper {

	public int mIdCheck(String mId);
	public Member getMemberInfo(String mId);
	
	public Member findId(String mName, String mTel, String mEmail);
	
}
