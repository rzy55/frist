package com.hnjd.news.services;

import java.sql.SQLException;

import com.hnjd.news.dao.UserDao;
import com.hnjd.news.dao.UserDaoImpl;
import com.hnjd.news.entity.User;

public class UserService {

	UserDao userDao =new UserDaoImpl(); 
	public boolean userRegister(User user) {
		int result = 0;
		try {
			User userByname = userDao.userByUname(user.getUname());
			if(userByname == null) {
				result = userDao.addUser(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result>0?true:false;
		
	}
	
	
}
