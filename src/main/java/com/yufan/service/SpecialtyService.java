package com.yufan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufan.bean.Bean;
import com.yufan.bean.Page;
import com.yufan.bean.SpecialtyBean;
import com.yufan.entity.Profession;

/**
 * 
* @ClassName: SpecialtyService  
* @Description:  专业管理 Service 层
* @author 雨ゆこ
* @date 2018年6月5日
* @version yuko1.0
 */
public interface SpecialtyService {
	/**
	 * 
	* @Title: createSpecialty  
	* @Description:   增加专业
	* @param @param profession    参数  
	* @return void    返回类型  
	* @throws
	 */
	void createSpecialty(Profession profession);
	/**
	 * 
	* @Title: updateSpecialty  
	* @Description:   更改专业 信息
	* @param @param profession    参数  
	* @return void    返回类型  
	* @throws
	 */
	void updateSpecialty(Profession profession);
	/**
	 * 
	* @Title: deleteSpecialty  
	* @Description:  根据 id 删除专业 
	* @param @param pId    参数  
	* @return void    返回类型  
	* @throws
	 */
	void deleteSpecialty(Integer pId);
	/**
	 * 
	* @Title: querySpecialtyByPage  
	* @Description:  分页查询 专业
	* @param @param page
	* @param @return    参数  
	* @return SpecialtyBean    返回类型  
	* @throws
	 */
	Bean<Profession> querySpecialtyByPage(Page page);
	/**
	 * 
	* @Title: queryAllSpecialty  
	* @Description:  查询所有 
	* @param @return    参数  
	* @return List<Profession>    返回类型  
	* @throws
	 */
	List<Profession> queryAllSpecialty();
	/**
	 * 
	* @Title: querySpecialtyById  
	* @Description:  根据id 查询
	* @param @param Integer 
	* @param @return    参数  
	* @return Profession    返回类型  
	* @throws
	 */
	Profession querySpecialtyById(Integer id);
	/**
	 * 
	* @Title: createSpeacialtyAndBook  
	* @Description:  插入 专业和图书关系
	* @param @param sid
	* @param @param bIds
	* @param @return    参数  
	* @return Integer    返回类型  
	* @throws
	 */
	Integer createSpeacialtyAndBook(Integer sid,int[] bIds);
}
