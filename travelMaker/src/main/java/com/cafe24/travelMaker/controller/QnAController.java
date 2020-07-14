package com.cafe24.travelMaker.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.Notice;
import com.cafe24.travelMaker.domain.Question;
import com.cafe24.travelMaker.service.MsgService;
import com.cafe24.travelMaker.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QnAController{
	@Autowired private QuestionService questionService;
	@Autowired private MsgService msgService;
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
		return "redirect:/question/questionList";
	}
	
	@GetMapping("/answer")
	public String answer(Model model) {
		model.addAttribute("questionList", questionService.getAllQuestionList());
		return "/question/answer";
	}
	
	@GetMapping("/answerSuccess")
	public String answerSuccess(Question question, HttpSession session, Notice notice,
			@RequestParam(name = "qCode", required = false) String qCode,
			@RequestParam(name = "inputDescription", required = false) String inputDescription) {
		System.out.println(question + " <-- question answer()");
		System.out.println(qCode + " <-- qCode answer()");
		System.out.println(inputDescription + " <-- inputDescription answer()");
		String loginId = (String)session.getAttribute("SID");
		question.setQuestionCode(qCode);
		question.setqAnswer(inputDescription);
		notice.setmId(loginId);
		questionService.answer(question);
		msgService.questionNotice(notice);
		return "redirect:/question/answer";
	}
	
	@GetMapping("/myQuestion")
	public String myQuestion() {
		return "/question/myQuestion";
	}
	
	@GetMapping("/answerForm")
	public String answerForm(Model model, Question question, @RequestParam(name="qCode", required=false) String qCode) {
		question = questionService.getQuestionInfo(qCode);
		model.addAttribute("question", question);
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
		return "redirect:/question/questionList";
	}
	
	@GetMapping("/deleteQnA2")
	public String deleteQnA2(@RequestParam(name="qCode", required=false) String qCode) {
	    questionService.deleteQnA2(qCode);
		return "redirect:/question/answer";
	}

}
