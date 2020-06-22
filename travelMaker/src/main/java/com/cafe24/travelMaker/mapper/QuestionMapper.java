package com.cafe24.travelMaker.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Question;

@Mapper
public interface QuestionMapper {
	public int newQuestion(Question question);
	public List<Question> getQuestionResultList(String mId);
	public Question getQuestionInfo(String qCode);
	public int deleteQnA(String qCode);
	public int deleteQnA2(String qCode);
	public List<Question> getAllQuestionResultList();
	public int answer(Question question);
}
