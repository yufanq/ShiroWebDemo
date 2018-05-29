package com.yufan.dao;

import com.yufan.entity.AdminRole;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(Integer arId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Integer arId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}