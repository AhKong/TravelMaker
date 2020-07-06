package com.cafe24.travelMaker.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.cafe24.travelMaker.domain.Member;

@Mapper
public interface MemberMapper {

	public int addMember(Member member);
	public int mIdCheck(String mId);
	public Member getMemberInfo(String mId);
	public Member findId(Member member); //아이디 찾기
	public Member findPw(Member member); //비번 찾기
	public Member followersPage(String mId);
}
