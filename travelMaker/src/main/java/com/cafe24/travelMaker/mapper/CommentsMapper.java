package com.cafe24.travelMaker.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.ResReviewComments;
import com.cafe24.travelMaker.domain.SightsReviewComments;

@Mapper
public interface CommentsMapper {
	public int addResReviewComments(ResReviewComments comments);
	public ResReviewComments getResReivewComments(String commentsNum);
	public List<ResReviewComments> getResCommentsList(String resReviewNum);
	public int deleletResReviewComments(String commentsNum);
	public int addSightsReviewComments(SightsReviewComments comments);
	public List<SightsReviewComments> getSightsCommentsList(String sightsReviewNum);
	public int deleletSightsReviewComments(String commentsNum);
}
