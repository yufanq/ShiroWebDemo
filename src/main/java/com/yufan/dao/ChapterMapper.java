package com.yufan.dao;

import com.yufan.entity.Chapter;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}