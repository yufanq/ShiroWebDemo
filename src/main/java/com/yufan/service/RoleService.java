package com.yufan.service;

import java.util.List;

import com.yufan.entity.Role;

public interface RoleService {
	void createRole(Role role);

	void updateRole(Role role);

	void deleteRole(Role role);	
	
	List<Role> queryAllRole();
}
