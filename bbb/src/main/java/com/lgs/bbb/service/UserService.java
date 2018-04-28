package com.lgs.bbb.service;

import com.lgs.bbb.dao.UserDao;
import com.lgs.bbb.entity.User;

public class UserService {
	private UserDao ud=new UserDao();
	public boolean LoginService(String username, String password) {
		User user=ud.getUser(username, password);
		if(user!=null) {
			return true;
		}
		return false;
	}
}
