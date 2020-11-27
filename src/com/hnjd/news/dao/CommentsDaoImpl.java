package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnjd.news.entity.Comment;

public class CommentsDaoImpl extends BaseDao implements CommentsDao {

	@Override
	public List<Comment> getCommentsById(int nid) throws SQLException {
	    List<Comment> list = new ArrayList<Comment>();
		String sql="select * from comments where cnid=? order by cdate desc";
		ResultSet rs = excuteQuery(sql,nid);
		while(rs.next()) {
			Comment comment = new Comment();
			 comment.setCid(rs.getInt("cid"));
             comment.setCnid(rs.getInt("cnid"));
             comment.setCauthor(rs.getString("cauthor"));
             comment.setCip(rs.getString("cip"));
             comment.setCcontent(rs.getString("ccontent"));
             comment.setCdate(rs.getTimestamp("cdate"));
             list.add(comment);
		}
		
		return list;
	}

	@Override
	public int addComment(Comment comment) throws SQLException {
		String sql="insert into comment (cnid,ccontent,cdate,cip,cauthor) value (?,?,?,?,?)";
		int result = excuteUpdate(sql,comment.getCnid(),
				comment.getCcontent(),
				comment.getCdate(),
				comment.getCip(),
				comment.getCauthor());
		return result;
	}

	@Override
	public int deleteCommentsByNid(int nid) throws SQLException {
		String sql="delete from comment where cnid=?";
		int result=excuteUpdate(sql, nid);
		
		return result;
	}

	@Override
	public int deleteCommentsById(int cid) throws SQLException {
		String sql="delete from comment where cid=?";
		int result=excuteUpdate(sql, cid);
		
		return result;
	}

}
