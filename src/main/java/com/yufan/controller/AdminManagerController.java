package com.yufan.controller;

import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yufan.entity.Admin;
import com.yufan.entity.Jurisdiction;
import com.yufan.service.AdminService;
import com.yufan.service.JurisdictionService;
import com.yufan.service.RoleService;
import com.yufan.view.bind.annotation.CurrentUser;

@Controller
@RequestMapping("/admin")
public class AdminManagerController {

	@Autowired
	private AdminService adminService; // 管理员服务
	@Autowired
	private RoleService roleService; // 角色服务接口
	@Autowired
	private JurisdictionService jurisdictionService;
	
	
	@RequiresPermissions("jurisdiction:admin:view")
	@RequestMapping(method= RequestMethod.GET)
	public String adminList(@CurrentUser Admin admin,Model model){
		// 查询 管理员列表
		model.addAttribute("adminList", adminService.queryAllAdmin());
		// 修改管理员角色 的下拉列表 
		model.addAttribute("adminRoleList", adminService.queryAllAdmin());
		// 已拥有的角色
		model.addAttribute("belongRole", roleService.queryRoleByBelongtoAdmin(admin));
		// 未拥有的角色
		model.addAttribute("noBelongRole",roleService.queryRoleByNoBelongtoAdmin(admin));
		return "adminmanager";
	}
	
	@RequiresPermissions("jurisdiction:admin:create")
	@RequestMapping(method = RequestMethod.POST, value="/create")
	public String adminAdd(Admin admin,RedirectAttributes redirectAttributes){
		try{
			// 插入操作
			adminService.createAdmin(admin);
			redirectAttributes.addAttribute("msg","添加成功");
		}catch(Exception e){
			//异常处理
			redirectAttributes.addAttribute("msg","添加失败");
			
		}
		return "redirect:/admin";
	}
	
	
}
