package com.yufan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.yufan.bean.ObjectBelongtoBean;
import com.yufan.bean.Page;
import com.yufan.entity.Book;
import com.yufan.entity.Profession;
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
		//  专业 分页 列表
 		model.addAttribute("specialtyBeanList", specialtyService.querySpecialtyByPage(page).getList());
		// 专业 下拉列表
 		List<Profession> queryAllSpecialty = specialtyService.queryAllSpecialty();
 		model.addAttribute("specialtyList",queryAllSpecialty );
 		if(queryAllSpecialty.size() != 0){
 			model.addAttribute("bookNoBelong",bookService.queryBookByNoBelongToSpecialty(queryAllSpecialty.get(0)));
 			model.addAttribute("bookBelong", bookService.queryBooksByBelongToSpecialty(queryAllSpecialty.get(0)));
 		}
		return"majormanager";
		
	}
	@RequiresPermissions("index:major:accredit")
	@RequestMapping(method= RequestMethod.GET,value="/{id}/selectSpecialtyBook")
	public void selectSpecialtyBook(@PathVariable("id")Integer id,Model model,HttpServletResponse response) throws IOException{
		// 设置 字符集
		response.setContentType("text/text;charset=UTF-8");
		//  打印出去
		PrintWriter out = response.getWriter();
		// 选中的id
		Profession querySpecialtyById = specialtyService.querySpecialtyById(id);
		//  封装
		ObjectBelongtoBean<Book> bean = new 
				ObjectBelongtoBean<Book>(bookService.queryBooksByBelongToSpecialty(querySpecialtyById),
						bookService.queryBookByNoBelongToSpecialty(querySpecialtyById));
		String jsonString = JSON.toJSONString(bean);
		// 打印
		out.print(jsonString);
	}

}
