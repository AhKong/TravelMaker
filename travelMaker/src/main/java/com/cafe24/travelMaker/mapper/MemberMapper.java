package com.cafe24.travelMaker.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.domain.MemberLogin;

@Mapper
public interface MemberMapper {

	public int addMember(Member member);
	public int mIdCheck(String mId);
	public Member getMemberInfo(String mId);
	public Member findId(Member member); //아이디 찾기
	public Member findPw(Member member); //비번 찾기
	public Member followersPage(String mId);
	public int updateMember(Member member); 			  //회원정보 수정
	public int deleteMAvatar(String mAvatar, String mId); //프로필 사진 변경 시 1)사진 지우기
	public int updateMAvatar(String mAvatar, String mId); //프로필 사진 변경 시 2)재업로드
	public int deleteMember(String mId); 				  //탈퇴
	public List<Member> getDeleteMemberList();			  //탈퇴회원 조회
	public String conciliateDeleteMember(Member member);  //탈퇴 회유
	public List<Member> getDormantMemberList();			  //휴면회원 조회
	public List<Member> selectDormantMember();			  //휴면처리 대상자 조회
	public int addLoginLog(MemberLogin memberLogin);
	
}
