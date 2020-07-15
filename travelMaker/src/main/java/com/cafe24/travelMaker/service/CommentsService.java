package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ResReviewComments;
import com.cafe24.travelMaker.mapper.CommentsMapper;

@Service
public class CommentsService {
	@Autowired private CommentsMapper commentsMapper;
	@Autowired private NoticeService noticeService;
	
	public int addResReviewComments(ResReviewComments comments,String reviewWirter) {
		String commentsWriter=comments.getMember().getmId();
		if(!commentsWriter.equals(reviewWirter)) {	
			noticeService.addNoticeForComments(commentsWriter, reviewWirter);
		}
		return commentsMapper.addResReviewComments(comments);
	}
	
	public ResReviewComments getResReivewComments(String commentsNum) {
		return commentsMapper.getResReivewComments(commentsNum);
	}
	
	public List<ResReviewComments> getResCommentsList(String resReviewNum){
		return commentsMapper.getResCommentsList(resReviewNum);
	}
	public int deleletResReviewComments(String commentsNum) {
		return commentsMapper.deleletResReviewComments(commentsNum);
	}
}
