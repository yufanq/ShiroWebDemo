package com.yufan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufan.service.QuestionTypeService;

@Controller
@RequestMapping(value="/questiontype")
public class QuestionTypeManagerController {
	@Autowired
	private QuestionTypeService questionTypeService;
	

}
