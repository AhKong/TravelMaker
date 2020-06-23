package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Message;

@Mapper
public interface MsgMapper {
	public int sendMsg(Message msg);
}
