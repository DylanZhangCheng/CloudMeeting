package com.dao;

import com.comm.BaseDao;
import com.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	public int doDelete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User doLogin(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	public int doRegister(User u) {
		 String sql="insert into myuser values(null,?,?)";
		 Object[] obs={u.getUname(),u.getUpwd()};
		return executeUpdate(sql, obs);
	}
	
	
	

}
