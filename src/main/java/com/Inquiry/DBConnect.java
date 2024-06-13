package com.Inquiry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {
	
	

	
	
	
	
	private static String url = "jdbc:mysql://localhost:3306/transport_system";
	private static String dbUser = "root";
	private static String dbPword = "200821";
	
	public static Statement getDBConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection con = DriverManager.getConnection(url, dbUser, dbPword);
			Statement stmt = con.createStatement();
			return stmt;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}
