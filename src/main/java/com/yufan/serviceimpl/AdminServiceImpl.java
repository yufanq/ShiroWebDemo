package com.yufan.serviceimpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yufan.dao.AdminMapper;
import com.yufan.dao.JurisdictionMapper;
import com.yufan.dao.RoleMapper;
import com.yufan.entity.Admin;
import com.yufan.entity.Jurisdiction;
import com.yufan.entity.Role;
import com.yufan.service.AdminService;
import com.yufan.util.PasswordHelper;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	@Autowired 
	private PasswordHelper passwordHelper;
	@Override
	public void createAdmin(Admin admin) {
		//加密密码
		passwordHelper.encryptPassword(admin);
		adminMapper.insert(admin);
		
	}
	@Override
	public void updateAdmin(Admin admin) {
		passwordHelper.encryptPassword(admin);
		adminMapper.updateByPrimaryKeySelective(admin);

		
	}
	@Override
	public void deleteAdmin(Integer id) {
		adminMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public List<Admin> queryAllAdmin() {
		return adminMapper.selectAllAdmin();
	}

	@Override
	public Admin queryAdmin(String username) {
		
		return adminMapper.selectByName(username);
	}
	@Override
	public Set<String> queryRoles(String username) {
		Set<Role> roles = adminMapper.selectAdminRole(username).getRoles();
		Set<String> rs = new HashSet<String>();
		for(Role r :roles){
			rs.add(r.getrName()); // 角色名称
		}
		return rs;
	}
	@Override
	public Set<String> queryJurisdiction(String username) {
		 Set<Jurisdiction> jurisdictions = adminMapper.selectAdminJuricdiction(username).getJurisdictions();
		 Set<String> js = new HashSet<String>();
		 for (Jurisdiction j : jurisdictions) {
			 js.add(j.getlPermission());// 权限字符串
		}
		return js;
	}
	

}
