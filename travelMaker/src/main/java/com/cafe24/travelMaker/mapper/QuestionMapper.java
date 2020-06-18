package com.cafe24.travelMaker.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Question;

@Mapper
public interface QuestionMapper {
	public int newQuestion(Question question);
}
