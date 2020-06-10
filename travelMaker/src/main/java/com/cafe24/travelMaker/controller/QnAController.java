package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnAController{
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
