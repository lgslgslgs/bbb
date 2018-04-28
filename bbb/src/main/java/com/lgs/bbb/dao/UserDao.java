package com.lgs.bbb.dao;

import com.lgs.bbb.entity.User;
import com.lgs.bbb.util.JDBCUtil;

public class UserDao {
	public User getUser(String username,String password) {
		Object user=JDBCUtil.query(User.class, "select * from test_user where username=? and password=?", username,password);
		if(user!=null) {
			return (User)user;
		}
		return null;
	}
}
