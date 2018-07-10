package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false"; // useSSL=false - Gets rid of MySQL SSL warnings
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to DB: " + jdbcUrl);
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connected to DB!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
