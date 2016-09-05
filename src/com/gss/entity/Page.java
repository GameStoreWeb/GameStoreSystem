package com.gss.entity;

import java.util.List;

public class Page<T> {
	private int pageNo;
	private int pageSize;
	private int pageCount;
	private int totalCount;
	private List<T> list;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1;
		
		if(pageNo > this.pageCount)
			this.pageNo = this.pageCount;
	}
	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo > 1 ? pageNo : 1;
		this.pageSize = pageSize;
		
	}
	
	
}
