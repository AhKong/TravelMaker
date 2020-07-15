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
	
	/* 포인트 지급시 당사자에게 포인트 적립 알림 */
	
	public int addNototiceForSavePoint(String mId, int point , String cause) {
		String noticeContents = null;
		this.notice = new Notice();
		this.notice.setmId(mId);
		if(cause.equals("리뷰작성")) {
			noticeContents = "리뷰를 작성해주셔서 감사합니다! ";
		} else if("회원가입".equals(cause)) {
			noticeContents = "회원가입을 축하합니다! ";
		}
		noticeContents += point+"포인트 적립되었습니다.";
		this.notice.setNoticeContents(noticeContents);
		return noticeMapper.addNotice(this.notice);
	}
	
	public int addNoticeForComments(String commentWirter,String reviewWirter) {
		this.notice = new Notice();
		this.notice.setmId(reviewWirter);
		this.notice.setNoticeContents(commentWirter+"님이 리뷰에 댓글을 달았습니다!");
		return noticeMapper.addNotice(this.notice);
	}

}
