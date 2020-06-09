package com.cafe24.travelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnAController{
	@GetMapping("/question")
	public String question() {
		return "/question/question";
	}

}
