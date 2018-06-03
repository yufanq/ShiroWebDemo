package com.yufan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yufan.entity.Jurisdiction;
import com.yufan.entity.Role;

public interface JurisdictionMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    Jurisdiction selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);
    
    List<Jurisdiction> selectAllJurisdiction();
    
    List<Jurisdiction> selectJurisdictionByParentid(Integer parentid);
    
    Integer selectjurisdictionCount();
    
    List<Jurisdiction> selectAllJurisdictionByPage(@Param("start")Integer start,@Param("end") Integer end);
   
    List<Jurisdiction> selectJurisdictionByBelongtoRole(Role role);
}