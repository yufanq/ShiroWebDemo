package com.yufan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yufan.entity.Profession;

public interface ProfessionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
    
    List<Profession> selectALLProfession();
    
    List<Profession> selectProfessionByBean(@Param("start")Integer start,@Param("end") Integer end);
    
    Integer selectProfessionCount();
}