package com.yufan.controller;

import javax.print.attribute.standard.Media;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yufan.bean.Page;
import com.yufan.service.BookService;
import com.yufan.service.SpecialtyService;

/**
 * 
* @ClassName: SpecialtyManagerController  
* @Description:  专业管理控制器
* @author 雨ゆこ
* @date 2018年6月5日
* @version yuko1.0
 */
@Controller
@RequestMapping("/specialty")
public class SpecialtyManagerController {

	@Autowired
	private SpecialtyService specialtyService;
	@Autowired
	private BookService bookService;
	
	@RequiresPermissions("index:major:view")
	@RequestMapping(method = RequestMethod.GET)
	public String specialtyList(Model model,Page page){
		
		return"majormanager";
		
	}

}
