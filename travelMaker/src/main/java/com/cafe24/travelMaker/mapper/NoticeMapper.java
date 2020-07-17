package com.cafe24.travelMaker.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.cafe24.travelMaker.domain.Notice;

@Mapper
public interface NoticeMapper {
	public int addNotice(Notice notice);
	public int noticeNum(String mId);
	public List<Notice> noticeList(String targetId);
}
