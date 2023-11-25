package com.user.app.dao;

import java.sql.*;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/javaeedemo";
	private static String userName = "root";
	private static String password = "root@123";
	
	protected static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userName, password);
	}
}
