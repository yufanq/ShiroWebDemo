package com.yufan.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yufan.entity.Admin;
import com.yufan.util.PasswordHelper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config.xml")
public class AdminMapperTest {
	
	@Autowired
	private AdminMapper adminMapper;

	@Autowired 
	private PasswordHelper passwordHelper;
	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
			Admin a = new Admin("admin","123456");
			passwordHelper.encryptPassword(a);
			
			adminMapper.insert(a);
			System.out.println("成功");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		List<Admin> selectAllAdmin = adminMapper.selectAllAdmin();
		System.out.println(selectAllAdmin);
		
	}

	@Test
	public void testSelectByName(){
		Admin selectAdminRole = adminMapper.selectByName("admin2");
		System.out.println(selectAdminRole);
	}
	@Test
	public void testSelectAdminRole(){
		Admin selectAdminRole = adminMapper.selectAdminRole("admin");
		System.out.println(selectAdminRole);
	}
	@Test
	public void testSelectByJuricdiction(){
		Admin selectAdminRole = adminMapper.selectAdminJuricdiction("admin");
		System.out.println(selectAdminRole);
	}
}
