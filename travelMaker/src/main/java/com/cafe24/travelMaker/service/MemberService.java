package com.cafe24.travelMaker.service;

import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.domain.MemberLogin;
import com.cafe24.travelMaker.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired public MemberMapper memberMapper;
	
	public Member findId(Member member) { //아이디 찾기
		System.out.println(member +" <----------Service findId");
		StandardPBEStringEncryptor jasypt = encryptor();
	    String encryptedTel = jasypt.encrypt(member.getmTel());  
	    member.setmTel(encryptedTel);
	    String encryptedEmail = jasypt.encrypt(member.getmEmail());  
	    member.setmEmail(encryptedEmail);
	   		
		return memberMapper.findId(member);  
	}
	
	public Member findPw(Member member) { // 비밀번호 찾기 아이디 전화번호 이메일 
		System.out.println(member + " <---------- Service findPw");
		StandardPBEStringEncryptor jasypt = encryptor();
		String encryptedTel = jasypt.encrypt(member.getmTel());  
		member.setmTel(encryptedTel);
		String encryptedEmail = jasypt.encrypt(member.getmEmail()); 
		member.setmEmail(encryptedEmail);
		
		Member result = memberMapper.findPw(member);
		if(result !=null) {
			String plainPw = jasypt.decrypt(member.getmPw()); 
			result.setmPw(plainPw);
		}
	return result;
	}
	
	public int mIdCheck(String mId) {
		return memberMapper.mIdCheck(mId);
	}

	public Member memberLogin(String mId) {
		StandardPBEStringEncryptor jasypt = encryptor();
		Member member = memberMapper.getMemberInfo(mId);
		/*로그인시 입력한 비밀번호와  DB에 암호화된 비밀번호의 일치여부를 확인하기 위한 복호화 */
		if(member !=null) {
			String plainPw = jasypt.decrypt(member.getmPw());
			member.setmPw(plainPw);
		}
		return member;
	}

	public int addMember(Member member) {
		/* 회원가입시 비밀번호, 전화번호, 이메일 정보에 대하여 암호화 */
		StandardPBEStringEncryptor jasypt = encryptor();
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
		Member result = memberMapper.getMemberInfo(mId);
		if(result !=null) {
			StandardPBEStringEncryptor jasypt = encryptor();
			String plainEmail = jasypt.decrypt(result.getmEmail()); 
			result.setmEmail(plainEmail);
			String plainTel = jasypt.decrypt(result.getmTel()); 
			result.setmTel(plainTel);
		}
		return result;
	}
	
	public Member followersPage(String mId) {
		return memberMapper.followersPage(mId);
	}
	
	public Member beforeUpdateMember(String mId) {	//수정 전 회원정보 가져오는거고  복호화
		StandardPBEStringEncryptor jasypt = encryptor();
		Member member = memberMapper.getMemberInfo(mId);
		if(member !=null) {
			String plainPw = jasypt.decrypt(member.getmPw()); 
			member.setmPw(plainPw);
			String plainTel =jasypt.decrypt(member.getmTel());  
			member.setmTel(plainTel);
		}
		return member;
	}
	
	public int updateMember(Member member) {	
		StandardPBEStringEncryptor jasypt = encryptor();
		 String encryptedPw = jasypt.encrypt(member.getmPw());  
	        member.setmPw(encryptedPw);
	        String encryptedTel = jasypt.encrypt(member.getmTel());  
	        member.setmTel(encryptedTel);
		//회원정보 수정 하는거 새롭게 받아서  암호화
	        System.out.println(member +"<-------updateMember");
	        int result = memberMapper.updateMember(member);
	        System.out.println(result +"<----updateMemberResult");
		return result;
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

	//탈퇴회원 관리
	public List<Member> getDeleteMemberList() {		//탈퇴 회원 조회
		System.out.println("getDeleteMemberList MemberService 도착");
		return memberMapper.getDeleteMemberList();
	}
		
	public int deleteMember(String mId) {			//탈퇴 처리
		System.out.println("잠시만요 너무 서운해용! 탈퇴하지 말아주세요 ㅠ deleteMember MemberService");
		return memberMapper.deleteMember(mId);
	}

	//휴면회원 관리
	public List<Member> getDormantMemberList() {	//휴면회원 리스트 
		System.out.println("getDormantMemberList MemberService 도착");
		return memberMapper.getDormantMemberList();
	}
	
	public List<Member> selectDormantMember() {		//휴면회원 대상자 조회
		System.out.println("selectDormantMember MemberService 도착");
		return memberMapper.selectDormantMember();
	}
}
