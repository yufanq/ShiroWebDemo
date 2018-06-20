package com.yufan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.yufan.bean.ObjectBelongtoBean;
import com.yufan.entity.Jurisdiction;
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
	@RequiresPermissions("jurisdiction:role:accredit")
	@RequestMapping(value="/{id}/selectRoleJurisdiction",method = RequestMethod.GET)
	public void selectRoleJurisdiction(@PathVariable("id")Integer id,Model model,HttpServletResponse response) throws IOException{
		// 设置 字符集
		response.setContentType("text/text;charset=UTF-8");
		//  打印出去
		PrintWriter out = response.getWriter();
		// 选中的角色
		Role queryRoleByid = roleService.queryRoleByid(id);
		// 属于该角色的权限
		List<Jurisdiction> queryJurisdictionByBolongtoRole = 
				jurisdictionService.queryJurisdictionByBolongtoRole(queryRoleByid);
		// 不属于该角色的权限
		List<Jurisdiction> queryJurisdictionNoByBolongtoRole = 
				jurisdictionService.queryJurisdictionNoByBolongtoRole(queryRoleByid);
		// 对象封装
		ObjectBelongtoBean<Jurisdiction> objectBelongtoBean = 
				new ObjectBelongtoBean<Jurisdiction>(queryJurisdictionByBolongtoRole, queryJurisdictionNoByBolongtoRole);
		String jsonString = JSON.toJSONString(objectBelongtoBean);
		out.print(jsonString);		
	}
}
