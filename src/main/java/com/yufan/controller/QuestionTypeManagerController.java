package com.yufan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.yufan.bean.Bean;
import com.yufan.bean.Page;
import com.yufan.entity.Questype;
import com.yufan.service.QuestionTypeService;

@Controller
@RequestMapping(value="/questiontype")
public class QuestionTypeManagerController {
	@Autowired
	private QuestionTypeService questionTypeService;
	
	@RequiresPermissions("index:questiontype:view")
	@RequestMapping(method=RequestMethod.GET)
	public String showQuestionTypeByPage(Page page,Model model){
		Bean<Questype> queryQuestionTypeByPage = questionTypeService.queryQuestionTypeByPage(page);
		model.addAttribute("questypeBean",queryQuestionTypeByPage );
		return "questiontype";
	}
	
	@RequiresPermissions("index:questiontype:update")
	@RequestMapping(method=RequestMethod.POST,value="/{id}/updateQuestionType")
	public void updateQuestionType(@PathVariable("id")Integer id,String questionTypeJson,HttpServletResponse response){
		// 设置字符集
		response.setContentType("text/text;charset=UTF-8");
		// 获取打印流
		PrintWriter writer = null;	
		try {
				writer = response.getWriter();
				// 接受到的数据
				Questype parseObject = JSON.parseObject(questionTypeJson, Questype.class);
				// 修改
				questionTypeService.updateQuestionType(parseObject);
			writer.print(1);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.print(0);
	}
	
	@RequiresPermissions("index:questiontype:create")
	@RequestMapping(method=RequestMethod.POST,value="/createQuestionType")
	public String createQuestionType(Questype questype,RedirectAttributes redirectAttributes){
		try{
			questionTypeService.createQuestionType(questype);
			redirectAttributes.addAttribute("msg", "添加成功");
		}catch(Exception e){
			redirectAttributes.addAttribute("msg", "添加失败");
		}
		return "redirect:/questiontype";
		
	}
	@RequiresPermissions("index:questiontype:delete")
	@RequestMapping(method=RequestMethod.GET,value="/{id}/deleteQuestionType")
	public String deleteQuestionType(@PathVariable("id")Integer id,RedirectAttributes redirectAttributes){
		try {
			questionTypeService.deleteQuestionType(id);
			redirectAttributes.addAttribute("msg", "删除成功");
		} catch (Exception e) {
			redirectAttributes.addAttribute("msg", "删除失败");
		}
		return "redirect:/questiontype";
	}
}
