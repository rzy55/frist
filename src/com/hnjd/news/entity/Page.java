package com.hnjd.news.entity;

import java.util.List;

public class Page {

	//1.��ǰҳ��
	private int currPage;
	
	//2.��ʾ��¼��
	private int pageSize;
	
	//3.�����б�
	private List<News> newsList;
	
	//4.�ܼ�¼��
	private int totalSize;
	
	//5.��ҳ��
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

	
	//��������������
	public void setTotalPage(int pageSize) {
		if(this.totalSize % pageSize == 0) {
			this.totalPage = this.totalSize /pageSize ;
		}if(this.totalSize % pageSize > 0) {
			this.totalPage = (this.totalSize /pageSize)  + 1;
		}
	}
	
}
