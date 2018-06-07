package com.yufan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.yufan.entity.Chapter;
import com.yufan.service.ChapterService;

@Controller
@RequestMapping("/chapter")
public class ChapterCManagerController {

	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}/selectBookChapter")
	public void selectBookChapter(@PathVariable("id") Integer id,Model model,HttpServletResponse response) throws IOException{
		// 设置字符集	// 设置 字符集
		response.setContentType("text/text;charset=UTF-8");
		// 获取打印流
		PrintWriter writer = response.getWriter();
		//  指定 图书的章节知识点
		List<Chapter> queryChapterByBookId = chapterService.queryChapterByBookId(id);
		// 转换成 JSON串
		String jsonString = JSON.toJSONString(queryChapterByBookId);
		// 打印
		writer.print(jsonString);
		
	}
	@RequestMapping(method= RequestMethod.POST, value = "/{id}/updateChapter")
	public void updateChapter(@PathVariable("id")Integer id,String chapterJson,Model model,HttpServletResponse response){
		Chapter parseObject = JSON.parseObject(chapterJson,Chapter.class);
		System.out.println(parseObject);
	}
}
