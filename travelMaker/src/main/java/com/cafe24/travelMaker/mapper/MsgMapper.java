package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Message;

@Mapper
public interface MsgMapper {
	public int sendMsg(Message msg);
	public List<Message> receivedMsgList(String mId);
	public Message getDetailMsg(String messageNum);
	public int readMsg(String messageNum);
	public int countUnReadMsg(String mId);
	public List<Message> sendMsgList(String mId);
	public int deleteMsg(String[] checkList);
	public List<Message> deleteMsgList(String mId);
}