package com.cafe24.travelMaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import com.cafe24.travelMaker.domain.FeedbackSights;

@Mapper
public interface FeedbackMapper {

	//피드백 보내기
	public int addFeedback(FeedbackSights feedbackSights);
	
	//피드백 리스트
	public List<FeedbackSights> feedbackList(Model model);
}
