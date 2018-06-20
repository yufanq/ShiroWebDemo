package com.yufan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.yufan.bean.Page;
import com.yufan.entity.Book;
import com.yufan.entity.Chapter;
import com.yufan.service.BookService;
import com.yufan.service.ChapterService;

@Controller
@RequestMapping("/book")
public class BookManagerController {
	
	@Resource(name = "bookServiceImpl")
	private BookService bookService; // book Service
	
	@Resource(name = "chapterServiceImpl")
	private ChapterService chapterService; // chapter Service
	
	@RequiresPermissions("index:book:view")
	@RequestMapping(method = RequestMethod.GET)
	public String bookList(Page page , Model model){
		model.addAttribute("bookBeanList", bookService.queryBookByPage(page).getList());
		// 所以图书
		List<Book> queryAllBooks = bookService.queryAllBooks();
		;
		if(queryAllBooks.size() != 0){
			model.addAttribute("bookList", queryAllBooks);
			// 章节知识点列表
			model.addAttribute("chapters", chapterService.queryChapterByBookId(queryAllBooks.get(0).getbId()));
		System.out.println(chapterService.queryChapterByBookId(1));
		}
		return "booksmanager";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createBook")
	@RequiresPermissions("index:book:create")
	public String bookCreate(Book book,Model model){
		bookService.createBook(book);;
		return "redirect:/book";
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/{id}/updateBook")
	@RequiresPermissions("index:book:update")
	public void bookUpdate(@PathVariable("id") Integer id,String bookJson,Model model, HttpServletResponse response) throws IOException{
		// 设置 字符集
		response.setContentType("text/text;charset=UTF-8");
		// 获取打印流
		PrintWriter writer = response.getWriter();

		Book parseObject = JSON.parseObject(bookJson, Book.class);
		
		int updateBook = bookService.updateBook(parseObject);
		
		writer.print(updateBook);
	}
	
	@RequiresPermissions("index:book:delete")
	@RequestMapping(method = RequestMethod.GET, value="/{id}/deleteBook")
	public void bookDalete(@PathVariable("id")Integer id,Model model,HttpServletResponse response) throws IOException{
		// 设置字符集
		response.setContentType("text/text;charset=UTF-8");
		// 获取打印流
		PrintWriter writer = response.getWriter();
		
		int deleteBook = bookService.deleteBook(id);
		
		writer.print(deleteBook);
		
	}
}
