package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestCase {
	
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String NAME = "hr";
	private static String PWD = "oracle";

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(URL, NAME, PWD);
		
		
		String sql = "select * from STU";
		
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("id : " + rs.getInt(1) + " \t SName : " + rs.getString(2));
		}
		
	}

}
