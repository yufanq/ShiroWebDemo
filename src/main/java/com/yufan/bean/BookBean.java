package com.yufan.bean;

import java.util.List;

import com.yufan.entity.Book;
/**
 * 
* @ClassName: BookBean  
* @Description:  分页图书bean
* @author 雨ゆこ
* @date 2018年6月5日
* @version yuko1.0
 */
public class BookBean {
	
	private List<Book> bookList; // 图书列表
	
	private Integer totalCount;  // 图书总数

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
