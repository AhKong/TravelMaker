package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Message;
import com.cafe24.travelMaker.mapper.MsgMapper;

@Service
public class MsgService {
	@Autowired private MsgMapper msgMapper;
	public int sendMsg(Message msg) {
		return msgMapper.sendMsg(msg);
	};
	
	public List<Message> receivedMsgList(String mId){
		return msgMapper.receivedMsgList(mId);
	}
	
	public Message getDetailMsg(String messageNum) {
		msgMapper.readMsg(messageNum); // 메시지 읽음여부로 변경
		return msgMapper.getDetailMsg(messageNum);
	}

}
