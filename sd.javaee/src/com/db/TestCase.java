package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestCase {
	
	private static String URL = "jdbc:mysql://localhost:3306/sd";
	private static String NAME = "root";
	private static String PWD = "root";

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, NAME, PWD);
		
		
		String sql = "select * from users";
		
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("uid : " + rs.getInt("uid") + " \t uName : " + rs.getString("uname"));
		}
		
	}

}
