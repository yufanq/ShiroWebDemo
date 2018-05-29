package com.yufan.dao;

import java.util.List;

import com.yufan.entity.Admin;
/**
 * 
* @ClassName: AdminMapper  
* @Description: 管理员操作类
* @author 雨ゆこ
* @date 2018年5月29日
* @version yuko1.0
 */
public interface AdminMapper {

    int deleteByPrimaryKey(Integer aId);
  
    int insert(Admin record);
    
    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    /**
     * 
    * @Title: selectByNameAndPassword  
    * @Description:  根据管理员账户和密码查询	 需要关联其他
    * @param @param admin
    * @param @return    参数  
    * @return Admin    返回类型  
    * @throws
     */
    Admin selectByName(String username);
    /**
     * 
    * @Title: selectAllAdmin  
    * @Description:  列出所有管理员
    * @param @return    参数  
    * @return List<Admin>    返回类型  
    * @throws
     */
    List<Admin> selectAllAdmin();
    /**
     * 
    * @Title: selectAdminRole  
    * @Description:  列出管理员所拥有的角色
    * @param @param username
    * @param @return    参数  
    * @return Admin    返回类型  
    * @throws
     */
    Admin selectAdminRole(String username);
    /**
     * 
    * @Title: selectAdminJuricdiction  
    * @Description:  列出管理员对应的权限
    * @param @param username
    * @param @return    参数  
    * @return Admin    返回类型  
    * @throws
     */
    Admin selectAdminJuricdiction(String username);
}