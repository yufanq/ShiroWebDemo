package com.yufan.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yufan.entity.Role;
import com.yufan.service.JurisdictionService;
import com.yufan.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleManagerController {

	@Autowired
	private RoleService roleService; // 角色Service
	
	@Autowired
	private JurisdictionService jurisdictionService; // 权限Service
	
	@RequestMapping(method = RequestMethod.GET)
	@RequiresPermissions("jurisdiction:role:view")
	public String roleList(Model model){
				List<Role> queryAllRole = roleService.queryAllRole();
				// 角色列表
		model.addAttribute("roleList",roleService.queryAllRole());
		// 角色选择下拉列表
		model.addAttribute("roleSelectList",roleService.queryAllRole());
		if(queryAllRole.size() == 0)
			return "rolemanager";
		// 已经拥有的权限
		model.addAttribute("belongRole", jurisdictionService.queryJurisdictionByBolongtoRole(queryAllRole.get(0)));
		// 未拥有的权限
		model.addAttribute("noBelongRole", jurisdictionService.queryJurisdictionNoByBolongtoRole(queryAllRole.get(0)));
		return "rolemanager";
	}
}
