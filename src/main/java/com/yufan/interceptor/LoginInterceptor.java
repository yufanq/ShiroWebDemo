package com.yufan.interceptor;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yufan.entity.Admin;
import com.yufan.entity.Jurisdiction;
import com.yufan.service.AdminService;
import com.yufan.service.JurisdictionService;
/**
 * 
* @ClassName: LoginInterceptor  
* @Description: 登录时拦截器 操作
* @author 雨ゆこ
* @date 2018年6月8日
* @version yuko1.0
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Autowired
	private JurisdictionService jurisdictionService;
	@Autowired
	private AdminService adminService;
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		 if(session.getAttribute("menus") == null){
			 Admin admin = (Admin) request.getAttribute("user");
			//查询用户所拥有权限
		        Set<String> permissions = adminService.queryJurisdiction(admin.getaAccount());  
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
			 
		 }
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
