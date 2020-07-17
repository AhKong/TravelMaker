package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cafe24.travelMaker.domain.Message;
import com.cafe24.travelMaker.domain.Notice;
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
	
	public int countUnReadMsg(String mId) {
		return msgMapper.countUnReadMsg(mId);
	}
	
	public List<Message> sendMsgList(String mId){
		return msgMapper.sendMsgList(mId);
	}
	
	public int deleteMsgs(String[] checkList) {
		return msgMapper.deleteMsgs(checkList);
	}
	
	public List<Message> deleteMsgList(String mId){
		return msgMapper.deleteMsgList(mId);
	}
	
	public int deleteMsg(String messageNum) {
		return msgMapper.deleteMsg(messageNum);
	}
	
	public List<Message> unReadMsgList(String targetId){
		return msgMapper.unReadMsgList(targetId);
	}
	
	public List<Notice> NoticeList(String mId) {
		return msgMapper.NoticeList(mId);
	}
	
	public int noticeCheckUpdate(String nCode) {
		return msgMapper.noticeCheckUpdate(nCode);
	}
}
