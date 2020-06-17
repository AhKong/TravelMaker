package com.cafe24.travelMaker.service;

import java.util.*;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Mail;

@Service
public class CertSerivce {
	 private Mail mail = new Mail();
	 private int pwdLength = 8;
	 private final char[] passwordTable =  { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
	                                            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
	                                            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
	                                            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
	                                            'w', 'x', 'y', 'z', '!', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	public String setRandomCode() {
        Random random = new Random(System.currentTimeMillis());
        int tablelength = passwordTable.length;
        StringBuffer buf = new StringBuffer();
        
        for(int i = 0; i < pwdLength; i++) {
            buf.append(passwordTable[random.nextInt(tablelength)]);
        }
        
        return buf.toString();
	
	}
	
	public HashMap<String,Object> certEmail(String mailAddr) {
		HashMap <String,Object> emailCert = new HashMap<String,Object>();
		String randomCode = setRandomCode();
		mail.setAddress(mailAddr);
		mail.setTitle("TravelMake 이메일 인증 코드입니다");
		mail.setMessage("인증코드는"+randomCode+"입니다");
		emailCert.put("randomCode",randomCode);
		emailCert.put("mail", mail);
		return emailCert;
	}
}
