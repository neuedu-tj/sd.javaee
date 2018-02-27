package com.dao;

import java.util.List;

import com.model.Users;

import jdbc.config.JDBCUtils;

public class UsersDao {
	
	
	public Users checkUsers(Users user) {
		
		String sql = "select uid,uname,pwd from users where uname = ? and pwd = ? ";
		Object[] params = {user.getUname() , user.getPwd() };
		
		JDBCUtils utils = new JDBCUtils();
		List users = utils.findByType(sql, Users.class, params);
		if(users!=null && users.size()>0) {
			return (Users)users.get(0);
		}
		return null;
		
	}

}
