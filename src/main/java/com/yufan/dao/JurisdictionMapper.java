package com.yufan.dao;

import java.util.List;

import com.yufan.entity.Jurisdiction;

public interface JurisdictionMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    Jurisdiction selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);
    
    List<Jurisdiction> selectAllJurisdiction();
}