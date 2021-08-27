package com.ilan.control.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MyConnection {

	public static Connection getConnection() {
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/flashcard?" + "useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
		String user = "root";
		String password = "1234";
		
		try {
			conn =DriverManager.getConnection(url, user, password);
		} catch (SQLException  e) {
			e.printStackTrace();
		}

		return conn;

	}
	
	
	@Test
	public void testConn() {
		Connection conn=MyConnection .getConnection();
		System.out.println(conn.toString());
	}
}
