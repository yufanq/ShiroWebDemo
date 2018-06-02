package com.yufan.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yufan.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config.xml")
public class RoleServiceTest {
	@Autowired
	private RoleService roleService;
	@Test
	public void testCreateRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAllRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryRoleByNoBelongtoAdmin() {
		Admin admin = new Admin();
		admin.setaAccount("admin");
		System.out.println(roleService.queryRoleByNoBelongtoAdmin(admin));
		
	}

	@Test
	public void testQueryRoleByBelongtoAdmin() {
		Admin admin = new Admin();
		admin.setaAccount("admin");
		System.out.println(roleService.queryRoleByBelongtoAdmin(admin));
	
	}

}
