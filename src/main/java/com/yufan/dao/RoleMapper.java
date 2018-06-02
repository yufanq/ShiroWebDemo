package com.yufan.dao;

import java.util.List;

import com.yufan.entity.Admin;
import com.yufan.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectAllRole();
    
    List<Role> selectRoleBybelongtoAdmin(Admin admin);
    
}