package com.yufan.service;

import java.util.List;

import com.yufan.bean.Bean;
import com.yufan.bean.Page;
import com.yufan.entity.Book;
import com.yufan.entity.Profession;

/**
 * 
* @ClassName: BookService  
* @Description: 图书 Service
* @author 雨ゆこ
* @date 2018年6月5日
* @version yuko1.0
 */
public interface BookService {

	/**
	 * 
	* @Title: createBook  
	* @Description:   添加图书
	* @param @param book    参数  
	* @return void    返回类型  
	* @throws
	 */
	void createBook(Book book);
	/**
	 * 
	* @Title: updateBook  
	* @Description:  修改图书信息
	* @param @param book    参数  
	* @return void    返回类型  
	* @throws
	 */
	void updateBook(Book book);
	/**
	 * 
	* @Title: deleteBook  
	* @Description:  删除 图书信息
	* @param @param id    参数  
	* @return void    返回类型  
	* @throws
	 */
	void deleteBook(Integer id);
	/**
	 * 
	* @Title: queryAllBooks  
	* @Description:  查询所有图书
	* @param @return    参数  
	* @return List<Book>    返回类型  
	* @throws
	 */
	List<Book> queryAllBooks();  	
	/**
	 * 
	* @Title: queryBookByPage  
	* @Description:  分页查询 图书
	* @param @param page
	* @param @return    参数  
	* @return Bean<Book>    返回类型  
	* @throws
	 */
	Bean<Book> queryBookByPage(Page page);
	/**
	 * 
	* @Title: queryBooksByBelongToSpecialty  
	* @Description:  查询属于 该专业 的图书
	* @param @param profession
	* @param @return    参数  
	* @return List<Book>    返回类型  
	* @throws
	 */
	List<Book> queryBooksByBelongToSpecialty(Profession profession);
	/**
	 * 
	* @Title: queryBookByNoBelongToSpecialty  
	* @Description:  查询 不属于 该专业的 图书
	* @param @param profession
	* @param @return    参数  
	* @return List<Book>    返回类型  
	* @throws
	 */
	List<Book> queryBookByNoBelongToSpecialty(Profession profession);
}
