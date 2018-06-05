package com.yufan.bean;

import java.util.List;
/**
 * 
* @ClassName: ObjectBelongtoBean  
* @Description: 
* @author 雨ゆこ
* @date 2018年6月5日
* @version yuko1.0
 */
public class ObjectBelongtoBean<E> {
	 List<E> belongtoBeanList;
	 List<E> noBelongtoBeanList;
	public ObjectBelongtoBean(List<E> belongtoBeanList,
			List<E> noBelongtoBeanList) {
		super();
		this.belongtoBeanList = belongtoBeanList;
		this.noBelongtoBeanList = noBelongtoBeanList;
	}
	public List<E> getBelongtoBeanList() {
		return belongtoBeanList;
	}
	public void setBelongtoBeanList(List<E> belongtoBeanList) {
		this.belongtoBeanList = belongtoBeanList;
	}
	public List<E> getNoBelongtoBeanList() {
		return noBelongtoBeanList;
	}
	public void setNoBelongtoBeanList(List<E> noBelongtoBeanList) {
		this.noBelongtoBeanList = noBelongtoBeanList;
	}
	@Override
	public String toString() {
		return "ObjectBelongtoBean [belongtoBeanList=" + belongtoBeanList
				+ ", noBelongtoBeanList=" + noBelongtoBeanList + "]";
	}
	
	 
}
