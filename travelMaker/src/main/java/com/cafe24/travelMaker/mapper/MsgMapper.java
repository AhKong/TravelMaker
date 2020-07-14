package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.domain.Message;
import com.cafe24.travelMaker.domain.Notice;

@Mapper
public interface MsgMapper {
	public int sendMsg(Message msg);
	public List<Message> receivedMsgList(String mId);
	public Message getDetailMsg(String messageNum);
	public int readMsg(String messageNum);
	public int countUnReadMsg(String mId);
	public List<Message> sendMsgList(String mId);
	public int deleteMsgs(String[] checkList);
	public List<Message> deleteMsgList(String mId);
	public int deleteMsg(String messageNum);
	public List<Message> unReadMsgList(String targetId);
	public List<Notice> NoticeList(String mId);
	public int noticeCheckUpdate(String nCode);
	public int questionNotice(Notice notice);
}