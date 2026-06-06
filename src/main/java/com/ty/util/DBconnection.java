package com.ty.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private static String url="jdbc:postgresql://localhost:5432/college";
	private static String username="postgres";
	private static String pwd="root";
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,username,pwd);
			return con;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
