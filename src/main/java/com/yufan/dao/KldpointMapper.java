package com.yufan.dao;

import com.yufan.entity.Kldpoint;

public interface KldpointMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Kldpoint record);

    int insertSelective(Kldpoint record);

    Kldpoint selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Kldpoint record);

    int updateByPrimaryKey(Kldpoint record);
}