package com.yufan.dao;

import com.yufan.entity.PaperQuestion;

public interface PaperQuestionMapper {
    int deleteByPrimaryKey(Integer pqId);

    int insert(PaperQuestion record);

    int insertSelective(PaperQuestion record);

    PaperQuestion selectByPrimaryKey(Integer pqId);

    int updateByPrimaryKeySelective(PaperQuestion record);

    int updateByPrimaryKey(PaperQuestion record);
}