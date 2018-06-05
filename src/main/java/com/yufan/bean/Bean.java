package com.yufan.bean;

import java.util.List;
/**
 * 
* @ClassName: Bean  
* @Description:  泛型 Bean
* @author 雨ゆこ
* @date 2018年6月5日
* @version yuko1.0
 */
public class Bean<E> {
	private List<E> list ;
	private Integer totalCount;
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}


}
