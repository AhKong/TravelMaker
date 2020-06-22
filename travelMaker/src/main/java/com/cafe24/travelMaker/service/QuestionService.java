package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.travelMaker.domain.Question;
import com.cafe24.travelMaker.mapper.QuestionMapper;

@Service
@Transactional
public class QuestionService {
	@Autowired private QuestionMapper questionMapper;
	
	public int newQuestion(Question question) {
		return questionMapper.newQuestion(question);
	}
	
	public List<Question> getQuestionList(String mId){
		return questionMapper.getQuestionResultList(mId);	
	}
	
	public Question getQuestionInfo(String qCode) {
		return questionMapper.getQuestionInfo(qCode);
	}
	
	public int deleteQnA(String qCode) {
		return questionMapper.deleteQnA(qCode);
	}
	
	public int deleteQnA2(String qCode) {
		return questionMapper.deleteQnA2(qCode);
	}
	
	public List<Question> getAllQuestionList(){
		return questionMapper.getAllQuestionResultList();
	}
	
	public int answer(Question question) {
		return questionMapper.answer(question);
	}
}
