package com.cafe24.travelMaker.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String questionList(Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("SID");
		System.out.println(loginId + " <-- loginId questionList() QnAController.java");
		List<Question> questionList = questionService.getQuestionList(loginId);
		System.out.println(questionList + " <-- loginId questionList() QnAController.java");
		model.addAttribute("questionList", questionList);
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
	public String detailQuestion(Model model, Question question, @RequestParam(name="qCode", required=false) String qCode) {
		question = questionService.getQuestionInfo(qCode);
		model.addAttribute("question", question);
		return "/question/detailQuestion";
	}

	@GetMapping("/deleteQnA")
	public String deleteQnA(@RequestParam(name="qCode", required=false) String qCode) {
	    questionService.deleteQnA(qCode);
		return "redirect:/questionList";
	}

}
