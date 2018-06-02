package com.yufan.bean;
/**
 * 
* @ClassName: Page   
* @Description: 
* @author 雨ゆこ　yu0214fan.gmail.com    
* @date 2018年1月5日 下午1:13:59   
*
 */
public class Page {
	// 页号
		private int pageIndex;
		// 每一页显示多少条
		private int pageSize;
		// 总条数 来源于数据库 count(*)
		private int totalCount; 
		// 总页数 = totalCount|pageSize关系
		private int pageCount;

		public Page() {
		   this.pageSize=5;
		   this.pageIndex = 1;
		}

		public Page(int pageIndex) {
			this(pageIndex, 5);
		}

		public Page(int pageIndex, int pageSize) {
			this.pageIndex = pageIndex;
			this.pageSize = pageSize;
		}

		public int getPageIndex() {
			return pageIndex;
		}

		public void setPageIndex(int pageIndex) {
			this.pageIndex = pageIndex;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getTotalCount() {
			return totalCount;
		}

		/*
		 * 设计目的：设置totalCount ----- pageCount
		 */
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
			this.pageCount = (totalCount%pageSize ==0)? totalCount/pageSize:totalCount/pageSize+1;
		                         
		}

		public int getPageCount() {
			return pageCount;
		}

		/*
		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
		*/
		
		public int getFirstResult(){
			return (pageIndex-1)*pageSize+1;
		}
		
		
		public int getLastResult(){
			return pageIndex*pageSize;
		}
		
		public  boolean getHasNextPage(){
			return pageIndex < pageCount;
		}
		
		public boolean getHasPrivousPage(){
			return pageIndex > 1;
		}

		public Integer getStart(){
			
			return (pageIndex - 1) * pageSize;
		}
		
		public Integer getEnd(){
			return pageSize;
		}
		@Override
		public String toString() {
			return "Page [pageIndex=" + pageIndex + ", pageSize=" + pageSize
					+ ", totalCount=" + totalCount + ", pageCount=" + pageCount
					+ "]";
		}
		
		
}
