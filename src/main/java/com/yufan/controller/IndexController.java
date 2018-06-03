package com.yufan.controller;

import net.sf.ehcache.util.FindBugsSuppressWarnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufan.entity.Admin;
import com.yufan.entity.Jurisdiction;
import com.yufan.service.AdminService;
import com.yufan.service.JurisdictionService;
import com.yufan.view.bind.annotation.CurrentUser;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
/**
 * 
* @ClassName: IndexController  
* @Description: 
* @author 雨ゆこ
* @date 2018年5月30日
* @version yuko1.0
 */
@Controller
public class IndexController {

    @Autowired
    private JurisdictionService jurisdictionService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public String index(@CurrentUser Admin loginUser, Model model,HttpSession session) {
    	//查询用户所拥有权限
        Set<String> permissions = adminService.queryJurisdiction(loginUser.getaAccount());  
        // 查询菜单项
        List<Jurisdiction> menus = jurisdictionService.findMenus(permissions);
        // 查询所跳转的菜单项的子项
        for (Jurisdiction jurisdiction : menus) {
        	List<Jurisdiction> findLists2 = jurisdictionService.findLists(permissions, jurisdiction.getjParent());
        	//
        	List<Jurisdiction> findLists = jurisdictionService.findLists(permissions, jurisdiction.getjId());
			session.setAttribute(jurisdiction.getlUri()+"lists", findLists);
		
        }
        session.setAttribute("menus", menus);
        System.out.println(menus);
        return "aindex";
    }

 
    
}
