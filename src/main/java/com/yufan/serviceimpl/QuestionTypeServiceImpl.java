package com.yufan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufan.dao.KldpointMapper;
import com.yufan.dao.KldpointQuestypeMapper;
import com.yufan.dao.QuestionMapper;
import com.yufan.dao.QuestypeMapper;
import com.yufan.entity.KldpointQuestype;
import com.yufan.entity.Questype;
import com.yufan.service.QuestionTypeService;

@Service
@Transactional
public class QuestionTypeServiceImpl implements QuestionTypeService{

	@Autowired
	private QuestypeMapper questypeMapper;
	@Override
	public int createQuestionType(Questype questype) {
		return questypeMapper.insert(questype);
	}

	@Override
	public int updateQuestionType(Questype questype) {
		
		return  questypeMapper.updateByPrimaryKeySelective(questype);
	}

	@Override
	public int deleteQuestionType(Integer id) {
		return questypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Questype> queryAllQuestionType() {
		return questypeMapper.selectAllQuestionType();
	}

	@Override
	public Questype queryQuestionTypeByid(Integer id) {
		return questypeMapper.selectByPrimaryKey(id);
	}

	
}
