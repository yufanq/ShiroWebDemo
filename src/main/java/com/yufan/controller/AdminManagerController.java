package com.yufan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.yufan.bean.ObjectBelongtoBean;
import com.yufan.entity.Admin;
import com.yufan.entity.Jurisdiction;
import com.yufan.entity.Role;
import com.yufan.service.AdminService;
import com.yufan.service.JurisdictionService;
import com.yufan.service.RoleService;
import com.yufan.view.bind.annotation.CurrentUser;

@Controller
@RequestMapping("/admin")
public class AdminManagerController<E> {

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
	@RequiresPermissions("jurisdiction:admin:delete")
	@RequestMapping(method = RequestMethod.POST, value = "/{id}/delete")
	public void adminDelete(@PathVariable("id") Integer id,Model model){
		// Ajax
		try{
			// 删除 管理员
			adminService.deleteAdmin(id);
			
		} catch(Exception e){
			
		}
	}
	
	@RequiresPermissions("jurisdiction:admin:update")
	@RequestMapping(method = RequestMethod.POST,value = "/{id}/update")
	public void adminUpdate(@PathVariable("id") Integer id, Admin admin ,Model model){
		// Ajax
		try {
			admin.setaId(id);
			// 更新
			adminService.updateAdmin(admin);
			
		} catch (Exception e) {

		}
	}
	/**
	 * @throws IOException 
	 * 
	* @Title: selctAdminRole  
	* @Description:  ajax 
	* @param @param id
	* @param @param model    参数  
	* @return void    返回类型  
	* @throws
	 */
	@RequiresPermissions("jurisdiction:role:accredit")
	@RequestMapping(method = RequestMethod.GET,value = "/{id}/selctAdminRole")
	public void selctAdminRole(@PathVariable("id")Integer id,Model model,HttpServletResponse response) throws IOException{
		// 设置 字符集
		response.setContentType("text/text;charset=UTF-8");
		//  打印出去
		PrintWriter out = response.getWriter();
		// 需要查询的 管理员信息
		Admin adminById = adminService.queryAdminById(id);
		// 该管理员的角色
		List<Role> queryRoleByBelongtoAdmin = roleService.queryRoleByBelongtoAdmin(adminById);
		 // 不属于该管理员的角色
		List<Role> queryRoleByNoBelongtoAdmin = roleService.queryRoleByNoBelongtoAdmin(adminById);
		// 将两个 list 绑定到一起
		ObjectBelongtoBean<Role> objectBelongtoBean = new ObjectBelongtoBean<Role>(queryRoleByBelongtoAdmin, queryRoleByNoBelongtoAdmin);
		 // 将数据转换成 json  
		String jsonString = JSON.toJSONString(objectBelongtoBean);
		System.out.println(jsonString);
		// 打印数据
		out.print(jsonString);
		
	}
}
