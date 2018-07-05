package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.pojo.User;

public class UserServiceImpl implements UserService{
    UserDao dao= new UserDaoImpl();
	public boolean doRegister(User u) {
		if(dao.doRegister(u)>0){
			return true;
		}
		return false;
	}
	
	
	

}
