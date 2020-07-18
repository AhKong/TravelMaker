package com.cafe24.travelMaker.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.domain.MemberLogin;
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
	
	public int mIdCheck(String mId) {
		return memberMapper.mIdCheck(mId);
	}

	public Member memberLogin(String mId) {
		StandardPBEStringEncryptor jasypt = encryptor();
		Member member = memberMapper.getMemberInfo(mId);
		String plainPw = jasypt.decrypt(member.getmPw()); 
		member.setmPw(plainPw);
		System.out.println(plainPw+"<---------복호화 된 비밀번호");	//복호화
		return member;
	}

	public int addMember(Member member) {
		StandardPBEStringEncryptor jasypt = encryptor();
        
        /* 회원가입시 비밀번호, 전화번호, 이메일 정보에 대하여 암호화 */
        String encryptedPw = jasypt.encrypt(member.getmPw());  
        member.setmPw(encryptedPw);
        String encryptedTel = jasypt.encrypt(member.getmTel());  
        member.setmTel(encryptedTel);
        String encryptedEmail = jasypt.encrypt(member.getmEmail());  
        member.setmEmail(encryptedEmail);
        
        if("".equals(member.getmAvatar())) {
        	if("남".equals(member.getmGender())) {
        		member.setmAvatar("man.png");
        	} else if("".equals(member.getmGender())) {
        		member.setmAvatar("woman.png");
        	}
        }
        	

     
		return memberMapper.addMember(member);
	}

	public Member getMemberInfo(String mId) {
		return memberMapper.getMemberInfo(mId);
	}
	
	public Member followersPage(String mId) {
		return memberMapper.followersPage(mId);
	}
	
	public Member beforeUpdateMember(String mId) {	//수정 전 회원정보
		return memberMapper.getMemberInfo(mId);
	}
	
	public int updateMember(Member member) {	//회원정보 수정
		return memberMapper.updateMember(member);
	}
	
	public int deleteMAvatar(String mAvatar, String mId) {	//프로필 사진 변경 시 1)삭제
		return memberMapper.deleteMAvatar(mAvatar, mId);
	}
	
	public int updateMAvatar(String mAvatar, String mId) {	//프로필 사진 변경 시 2)재업로드
		return memberMapper.updateMAvatar(mAvatar, mId);
	}
	
	public StandardPBEStringEncryptor  encryptor(){
		StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
		jasypt.setPassword("ahkongnong");      //암호화 키(password)
	    jasypt.setAlgorithm("PBEWithMD5AndDES");
	    return jasypt;
	}
	
	public int addLoginLog(MemberLogin memberLogin) {
		return memberMapper.addLoginLog(memberLogin);
	}

}
