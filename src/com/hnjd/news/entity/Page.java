package com.hnjd.news.entity;

import java.util.List;

public class Page {

	//1.当前页数
	private int currPage;
	
	//2.显示记录数
	private int pageSize;
	
	//3.新闻列表
	private List<News> newsList;
	
	//4.总记录数
	private int totalSize;
	
	//5.总页数
	private int totalPage;
	

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	
	//具体情况具体分析
	public void setTotalPage(int pageSize) {
		if(this.totalSize % pageSize == 0) {
			this.totalPage = this.totalSize /pageSize ;
		}if(this.totalSize % pageSize > 0) {
			this.totalPage = (this.totalSize /pageSize)  + 1;
		}
	}
	
}
