package com.hnjd.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.hnjd.news.entity.News;

/**
 * 
 * @author Administrator
 * ���user������в��������巽��
 */
public interface NewsDao {
	//1.�鿴��������
	public List<News> getAllNews () throws Exception; 
	
	//2.���ݲ�ͬ���������Ͳ鿴����
	public List<News> getNewsByTopicId(int ntid);
	
	//3.����Id�鿴ĳ������
	public News getNewsById(int nid) throws Exception;
	
	//4.���һ������
	public int addNews(News news) throws Exception;
	
	//5.����Id�޸�����
	public int editNews(int nid,News news) throws Exception ;
	
	//5.����Idɾ������
	public int deleteNews(int nid) throws SQLException;
	
	//���ݷ�ҳ�鿴����
	public List<News> getNewsByPage(int contPage,int pageSize) throws SQLException;
	
	public List<News> getNewsByCondition(News news) throws SQLException;
	
	public List<News> getNewsByTid(int tid) throws SQLException;
}
