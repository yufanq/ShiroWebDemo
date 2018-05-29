package com.yufan.dao;

import com.yufan.entity.Profession;

public interface ProfessionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
}