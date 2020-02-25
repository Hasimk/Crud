package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

 public class DBUtil {
	
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String UserName="root";
	private static final String Password="root";
	private static final String URL="jdbc:mysql://localhost:3306/hasim";
	
	public static Connection get_conncetion() {
		
		Connection conn=null;
		
		
		try {
			Class.forName("Driver");
			
			conn=DriverManager.getConnection(URL,UserName,Password);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		return conn;
		
		
		
	}

}
