package com.yufan.dao;

import java.util.List;

import com.yufan.entity.KldpointQuestype;

public interface KldpointQuestypeMapper {
    int deleteByPrimaryKey(Integer ptId);

    int insert(KldpointQuestype record);

    int insertSelective(KldpointQuestype record);

    KldpointQuestype selectByPrimaryKey(Integer ptId);

    int updateByPrimaryKeySelective(KldpointQuestype record);

    int updateByPrimaryKey(KldpointQuestype record);
}