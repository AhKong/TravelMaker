package com.cafe24.travelMaker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Notice;

@Mapper
public interface NoticeMapper {
	public int addNotice(Notice notice);
	public int noticeNum(String mId);
}
