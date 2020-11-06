package com.hnjd.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.hnjd.news.entity.Comment;

public interface CommentsDao {

	//通过新闻id查找评论
	public List<Comment> getCommentsById(int nid) throws SQLException;
	
	//添加评论
	public int addComment(Comment comment) throws SQLException;
	
	//根据新闻Id删除评论
	public int deleteCommentsByNid(int nid) throws SQLException;
	
	//删除评论
	public int deleteCommentsById(int cid) throws SQLException;
}
