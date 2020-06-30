package com.cafe24.travelMaker.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Follow;

@Mapper
public interface FollowMapper {
	public List<Follow> followers(String mId);
	public List<Follow> following(String mId);
}
