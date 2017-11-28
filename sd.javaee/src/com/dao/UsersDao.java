package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Users;

public class UsersDao {
	
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String NAME = "hr";
	private static String PWD = "oracle";
	
	
	public Users checkUsers(Users user) {
		Users u = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, NAME, PWD);

			String sql = "select * from USERS where UNAME = ? AND PWD = ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPwd());

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				u = new Users();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setPwd(rs.getString(3));
			}
			
		} catch (Exception e) {
			System.out.println("--------------------");
			e.printStackTrace();
		}
		
		return u;
		
	}

}
