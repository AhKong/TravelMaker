package com.cafe24.travelMaker.service;

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
}
