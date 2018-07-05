package com.dao;

import com.pojo.User;

public interface UserDao {
	public int doRegister(User u);
	public int doDelete(int id);
	public User doLogin(User u);
	

}
