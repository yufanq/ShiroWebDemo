package com.yufan.service;

import java.util.List;
import java.util.Set;

import com.yufan.entity.Admin;
import com.yufan.entity.Jurisdiction;
import com.yufan.entity.Role;

/**
 * 
* @ClassName: AdminService  
* @Description:  管理员
* @author 雨ゆこ
* @date 2018年5月29日
* @version yuko1.0
 */
public interface AdminService {
/**
 * 
* @Title: createAdmin  
* @Description: 创建管理员
* @param @param admin    参数  
* @return void    返回类型  
* @throws
 */
	void createAdmin(Admin admin);

	void updateAdmin(Admin admin);
	
	void deleteAdmin(Integer id);
	
	List<Admin> queryAllAdmin();

	
	Admin queryAdmin(String username);
	Set<String> queryRoles(String username);
	Set<String> queryJurisdiction(String username);
	
}
