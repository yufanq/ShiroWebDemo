package com.yufan.dao;

import com.yufan.entity.Questype;

public interface QuestypeMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Questype record);

    int insertSelective(Questype record);

    Questype selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Questype record);

    int updateByPrimaryKey(Questype record);
}