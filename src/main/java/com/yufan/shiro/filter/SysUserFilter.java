package com.yufan.shiro.filter;

import java.util.List;
import java.util.Set;

import com.yufan.entity.Jurisdiction;
import com.yufan.service.AdminService;
import com.yufan.view.bind.annotation.Constants;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private AdminService adminService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, adminService.queryAdmin(username));
   
        return true;
    }
}
