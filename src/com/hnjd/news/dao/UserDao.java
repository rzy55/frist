package com.hnjd.news.dao;

import java.sql.SQLException;

import com.hnjd.news.entity.User;

public interface UserDao {

	public int addUser(User user) throws SQLException;
	public User userByUname(String uname) throws SQLException;
}
