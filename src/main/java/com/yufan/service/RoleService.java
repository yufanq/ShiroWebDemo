package com.yufan.service;

import java.util.List;
import java.util.Set;

import com.yufan.entity.Admin;
import com.yufan.entity.Role;

public interface RoleService {
	void createRole(Role role);

	void updateRole(Role role);

	void deleteRole(Role role);	
	
	List<Role> queryAllRole();
	/***
	 * 
	* @Title: queryRoleByBelongtoAdmin  
	* @Description:   查询不属于 该管理员的角色列表
	* @param @param admin
	* @param @return    参数  
	* @return List<Role>    返回类型  
	* @throws
	 */
	List<Role> queryRoleByNoBelongtoAdmin(Admin admin);
	
	List<Role> queryRoleByBelongtoAdmin(Admin admin);
}
