package com.yufan.dao;

import com.yufan.entity.Paper;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
}