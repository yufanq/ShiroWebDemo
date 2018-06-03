package com.yufan.bean;

import java.util.List;
import com.yufan.entity.Profession;

/**
 * 
* @ClassName: SpecialtyBean  
* @Description:  专业Bean
* @author 雨ゆこ
* @date 2018年6月3日
* @version yuko1.0
 */
public class SpecialtyBean {

	private List<Profession> professionList; // 专业 列表
	
	private Integer totalCount;  // 专业总数

	public List<Profession> getProfessionList() {
		return professionList;
	}

	public void setProfessionList(List<Profession> professionList) {
		this.professionList = professionList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
}
