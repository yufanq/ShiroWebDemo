package com.yufan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yufan.entity.KldpointQuestype;
import com.yufan.entity.Questype;

public interface QuestypeMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Questype record);

    int insertSelective(Questype record);

    Questype selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Questype record);

    int updateByPrimaryKey(Questype record);

    List<Questype> selectAllQuestionType();
    
    List<Questype> selectQuestionTypeByPage(@Param("start")Integer start,@Param("end")Integer end);
    
    Integer selectCountByQuestionType();
}