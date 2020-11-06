package com.hnjd.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.hnjd.news.entity.Comment;

public interface CommentsDao {

	//ͨ������id��������
	public List<Comment> getCommentsById(int nid) throws SQLException;
	
	//�������
	public int addComment(Comment comment) throws SQLException;
	
	//��������Idɾ������
	public int deleteCommentsByNid(int nid) throws SQLException;
	
	//ɾ������
	public int deleteCommentsById(int cid) throws SQLException;
}
