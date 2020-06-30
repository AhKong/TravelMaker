package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cafe24.travelMaker.mapper.MemberMapper;

@Service
public class FollowService {
	
	@Autowired public MemberMapper memberMapper;
	
}
