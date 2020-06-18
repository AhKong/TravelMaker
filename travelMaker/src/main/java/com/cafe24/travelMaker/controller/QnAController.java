package com.cafe24.travelMaker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.travelMaker.domain.Question;
import com.cafe24.travelMaker.service.QuestionService;

@Controller
public class QnAController{
	@Autowired private QuestionService questionService;
	@GetMapping("/faq")
	public String faq() {
		return "/question/faq";
	}
	
	@GetMapping("/questionList")
	public String questionList() {
		return "/question/questionList";
	}
	
	@GetMapping("/newQuestion")
	public String newQuestion() {
		return "/question/newQuestion";
	}
	
	@PostMapping("/newQuestion")
	public String newQuestion(Question question) {
		int result = questionService.newQuestion(question);
		return "/question/faq";
	}
	
	@GetMapping("/answer")
	public String answer() {
		return "/question/answer";
	}
	
	@GetMapping("/myQuestion")
	public String myQuestion() {
		return "/question/myQuestion";
	}
	
	@GetMapping("/answerForm")
	public String answerForm() {
		return "/question/answerForm";
	}
	
	@GetMapping("/detailQuestion")
	public String detailQuestion() {
		return "/question/detailQuestion";
	}
}
