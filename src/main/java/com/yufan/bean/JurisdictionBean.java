package com.yufan.bean;

import java.util.List;

import com.yufan.entity.Jurisdiction;

/**
 * 
* @ClassName: JurisdictionBean  
* @Description: 权限 的bean
* @author 雨ゆこ
* @date 2018年6月2日
* @version yuko1.0
 */
public class JurisdictionBean {
	private List<Jurisdiction> jurisdictionList; // 权限列表
	
	private Integer totalPage; // 权限个数

	public List<Jurisdiction> getJurisdictionList() {
		return jurisdictionList;
	}

	public void setJurisdictionList(List<Jurisdiction> jurisdictionList) {
		this.jurisdictionList = jurisdictionList;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
