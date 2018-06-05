package com.yufan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufan.bean.Bean;
import com.yufan.bean.Page;
import com.yufan.dao.BookMapper;
import com.yufan.entity.Book;
import com.yufan.entity.Profession;
import com.yufan.service.BookService;
@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	private BookMapper bookMapper; // 图书dao
	
	@Override
	public void createBook(Book book) {
		bookMapper.insert(book);
		
	}

	@Override
	public void updateBook(Book book) {
		bookMapper.updateByPrimaryKeySelective(book);
	}

	@Override
	public void deleteBook(Integer id) {
		bookMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Book> queryAllBooks() {

		return bookMapper.selectALLBooks();
	}

	@Override
	public Bean<Book> queryBookByPage(Page page) {
		Bean<Book> bean = new Bean<Book>();
		bean.setList(bookMapper.selectBooksByPage(page.getStart(), page.getEnd()));
		bean.setTotalCount(bookMapper.selectBooksCount());
		page.setTotalCount(bean.getTotalCount());
		return bean;
	}

	@Override
	public List<Book> queryBooksByBelongToSpecialty(Profession profession) {
	
		return bookMapper.selectBookByProfession(profession);
	}

	@Override
	public List<Book> queryBookByNoBelongToSpecialty(Profession profession) {
		// 所有图书
		List<Book> selectALLBooks = bookMapper.selectALLBooks();
		// 拥有图书
		List<Book> selectBookByProfession = bookMapper.selectBookByProfession(profession);
		// 未拥有图书
		selectALLBooks.removeAll(selectBookByProfession);
		
		return selectALLBooks;
	}

}
