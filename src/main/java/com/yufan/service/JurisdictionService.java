package com.yufan.service;

import java.util.List;
import java.util.Set;

import com.yufan.entity.Jurisdiction;
import com.yufan.entity.Role;

public interface JurisdictionService {
	
	void createJurisdiction(Jurisdiction jurisdiction);
	
	void updateJurisdiction(Jurisdiction jurisdiction);
	
	void deleteJurisdiction(Jurisdiction jurisdiction);
	/**
	 * 
	* @Title: queryAllJurisdiction  
	* @Description:  列出所有权限
	* @param @return    参数  
	* @return List<Jurisdiction>    返回类型  
	* @throws
	 */
	List<Jurisdiction> queryAllJurisdiction();
    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<Jurisdiction> findMenus(Set<String> permissions);

}
