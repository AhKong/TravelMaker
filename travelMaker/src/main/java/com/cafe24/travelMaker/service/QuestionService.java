package com.cafe24.travelMaker.service;

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
}
