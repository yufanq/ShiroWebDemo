package com.yufan.dao;

import com.yufan.entity.RoleJurisdiction;

public interface RoleJurisdictionMapper {
    int deleteByPrimaryKey(Integer rjId);

    int insert(RoleJurisdiction record);

    int insertSelective(RoleJurisdiction record);

    RoleJurisdiction selectByPrimaryKey(Integer rjId);

    int updateByPrimaryKeySelective(RoleJurisdiction record);

    int updateByPrimaryKey(RoleJurisdiction record);
}