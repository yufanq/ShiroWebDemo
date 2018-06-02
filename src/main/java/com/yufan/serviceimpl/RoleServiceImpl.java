package com.yufan.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yufan.dao.AdminMapper;
import com.yufan.dao.RoleMapper;
import com.yufan.entity.Admin;
import com.yufan.entity.Role;
import com.yufan.service.AdminService;
import com.yufan.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired 
	private AdminMapper adminMapper;
	@Override
	public void createRole(Role role) {
		// 插入
		roleMapper.insert(role);
	}

	@Override
	public void updateRole(Role role) {
		// 更新
		roleMapper.updateByPrimaryKeySelective(role);
		
	}

	@Override
	public void deleteRole(Role role) {
		// 删除
		roleMapper.deleteByPrimaryKey(role.getrId());
		
		
	}

	@Override
	public List<Role> queryAllRole() {
		return  roleMapper.selectAllRole();
	}

	@Override
	public List<Role> queryRoleByNoBelongtoAdmin(Admin admin) {	
		// 不属于管理员的角色
		List<Role> list = new ArrayList<Role>();
		// 管理员拥有的角色
		List<Role> selectRoleBybelongtoAdmin = roleMapper.selectRoleBybelongtoAdmin(admin);
		System.out.println("roles:"+ selectRoleBybelongtoAdmin);
		List<Role> queryAllRole = queryAllRole();
		System.out.println("all:" + queryAllRole);
		for (Role role : queryAllRole) {
			boolean flag = true;
			for (Role role1 : selectRoleBybelongtoAdmin) {
				if(role.getrId()  == role1.getrId()){ // 说明包含
					flag = false; // 假
					break; // 跳出
				}
			}
			if(flag){
				list.add(role);
			}
		}
		return list;
	}

	@Override
	public List<Role> queryRoleByBelongtoAdmin(Admin admin) {
		return roleMapper.selectRoleBybelongtoAdmin(admin);
	}

}
