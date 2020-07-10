package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.Notice;
import com.cafe24.travelMaker.domain.ReviewLike;
import com.cafe24.travelMaker.mapper.NoticeMapper;

@Service
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	private Notice notice;
	
	/* 리뷰 작성자한테 리뷰 좋아요 알림 */
	public int addNoticeForLike(String reviewWriter,ReviewLike reviewLike) {
		this.notice = new Notice();
		this.notice.setmId(reviewWriter);
		this.notice.setNoticeContents(reviewLike.getmId()+"님이 회원님의 리뷰에 좋아요를 눌렀습니다");
		return noticeMapper.addNotice(this.notice);
	}
	

}
