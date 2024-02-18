package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBConnection;

public class StudentController {
	//6 step of jdbc...
	//load driver...
	//getting connection with db..
	//create statement
	//prepare query
	//submit query
	//get result

	public void addStudent() {
		
		//get connection
		
		Connection conn = DBConnection.getDBConnection();
		//statement is an interface....
		//role of statement is to compile query...
		
		try {
			Statement stmt = conn.createStatement(); //3rd statement
			String insertSQL  = "insert into student(sname,sage)values('raj',20)"; //4th step
			//submit query..
			//stmt.execute(insertSQL); //boolean ... DML --> DDL 
			//stmt.executeUpdate(insertSQL); int --> DML query how many row affect
			//stmt.executeQuery(insertSQL) RESULT set --> DDL -->
			
			int res = stmt.executeUpdate(insertSQL);
			if(res>0) {
				System.out.println(res +" student inserted...");
			}
			else {
				System.out.println("student not inserted...");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		
		
		StudentController studentController = new StudentController();
		studentController.addStudent();
		
	}
}
