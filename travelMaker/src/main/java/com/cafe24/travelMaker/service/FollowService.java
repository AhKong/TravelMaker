package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Follow;
import com.cafe24.travelMaker.mapper.FollowMapper;

@Service
public class FollowService {
	
	@Autowired public FollowMapper followMapper;
	
	public List<Follow> followers(String mId){
		return followMapper.followers(mId);
	}
	public List<Follow> following(String mId){
		return followMapper.following(mId);
	}
	public int followInsert(Follow follow) {
		return followMapper.followInsert(follow);
	}
	public int followDelete(Follow follow) {
		return followMapper.followDelete(follow);
	}
}
