package com.yufan.dao;

import com.yufan.entity.ProfessionBook;

public interface ProfessionBookMapper {
    int deleteByPrimaryKey(Integer pbId);

    int insert(ProfessionBook record);

    int insertSelective(ProfessionBook record);

    ProfessionBook selectByPrimaryKey(Integer pbId);

    int updateByPrimaryKeySelective(ProfessionBook record);

    int updateByPrimaryKey(ProfessionBook record);
}