package com.dbconnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection get_connection() {
		
		Connection conn= null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hasim","root","root");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return conn;
		
		
	}
	
}
