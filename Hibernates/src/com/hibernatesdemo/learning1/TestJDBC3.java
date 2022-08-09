package com.hibernatesdemo.learning1;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC3 {

	private static final String JDBCURL = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
	private static final String CONNUSER = "hbstudent";
	private static final String CONNPASSWORD = "hbstudent";
	
	public static void main(String[] args) {
		try {
			System.out.println("Connecting to database...");
			Connection myConn = DriverManager.getConnection(JDBCURL, CONNUSER, CONNPASSWORD);
			System.out.println("Connection successful");
			if(myConn != null) {
				System.out.println("Closing connection");
				myConn.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
