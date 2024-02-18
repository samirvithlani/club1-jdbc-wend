package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//6 step of jdbc...
//load driver...
//getting connection with db..
//create statement
//prepare query
//submit query
//get result

//transcation management .

public class DBConnection {
	
	
	private static String userName ="root";
	private static String password = "root";
	private static String driverClassName ="com.mysql.jdbc.Driver";
	private static String connectionURL = "jdbc:mysql://localhost:3306/club1";
	
	
	public static Connection getDBConnection() {
		
		//load driver...
		Connection conn  = null;
		try {
			Class.forName(driverClassName); //withput new key word jar...
			conn = DriverManager.getConnection(connectionURL, userName, password);
			if(conn!=null) {
				System.out.println("connected with db..");
			}
			else {
				System.out.println("not connected with db...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
				
	}
	
	public static void main(String[] args) {
		
		DBConnection.getDBConnection();
		
		
	}
}
