package com.yufan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yufan.entity.Book;
import com.yufan.entity.Profession;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
    List<Book> selectALLBooks();
    
    List<Book> selectBooksByPage(@Param("start")Integer start,@Param("end") Integer end);
    
    Integer selectBooksCount();
    
    List<Book> selectBookByProfession(Profession profession);
}