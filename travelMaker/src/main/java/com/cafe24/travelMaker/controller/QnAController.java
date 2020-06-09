package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnAController{
	@GetMapping("/faq")
	public String faq() {
		return "/question/faq";
	}
	
	@GetMapping("/myQuestionList")
	public String myQuestionList() {
		return "/question/myQuestionList";
	}
	
	@GetMapping("/myQuestion")
	public String myQuestion() {
		return "/question/myQuestion";
	}
	
	@GetMapping("/answer")
	public String answer() {
		return "/question/answer";
	}
}
