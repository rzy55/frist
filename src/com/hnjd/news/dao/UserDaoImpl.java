package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hnjd.news.entity.User;
import com.hnjd.news.util.DatabaseUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int addUser(User user) throws SQLException {
		String sql="insert into news_users (uname,upwd) value (?,?)";
		int result = excuteUpdate(sql, user.getUname(),user.getUpwd());
		DatabaseUtil.closeAll(conn, pst, rs);
		return result;
	}

	@Override
	public User userByUname(String uname) throws SQLException {
		String sql="select * from news_users where uname=?";
		ResultSet result = excuteQuery(sql,uname);
	
		if(result.next()) {
			User user = new User();
			user.setUid(result.getInt("uid"));
			user.setUname(result.getString("uname"));
			user.setUpwd(result.getString("upwd"));
			return user;
		}
		return null ; 
		
	}

}
