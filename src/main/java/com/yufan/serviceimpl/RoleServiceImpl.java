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
		// 管理员拥有的角色
		List<Role> selectRoleBybelongtoAdmin = roleMapper.selectRoleBybelongtoAdmin(admin);
		 // 所有角色
		List<Role> queryAllRole = queryAllRole();
		// 不属于管理员的角色
		queryAllRole.removeAll(selectRoleBybelongtoAdmin);
		return queryAllRole;
	}

	@Override
	public List<Role> queryRoleByBelongtoAdmin(Admin admin) {
		return roleMapper.selectRoleBybelongtoAdmin(admin);
	}

	@Override
	public Role queryRoleByid(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

}
