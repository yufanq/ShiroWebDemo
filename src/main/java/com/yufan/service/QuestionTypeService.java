package com.yufan.service;

import java.util.List;

import com.yufan.entity.Questype;



public interface QuestionTypeService {
	
	int createQuestionType(Questype questype);
	
	int updateQuestionType(Questype questype);
	
	int deleteQuestionType(Integer id);
	
	List<Questype> queryAllQuestionType();
	
	Questype queryQuestionTypeByid(Integer id);
}
