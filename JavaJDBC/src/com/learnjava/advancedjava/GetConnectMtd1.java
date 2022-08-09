package com.learnjava.advancedjava;

import java.sql.DriverManager;
import java.sql.SQLException;

import sun.jdbc.odbc.JdbcOdbcDriver;

import java.sql.Connection;
import java.sql.Driver;

public class GetConnectMtd1 {

	public static void main(String[] args) {
		Connection conn=null;
//		try {
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		} catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}
		Driver d = new JdbcOdbcDriver();
		
		try {
			DriverManager.registerDriver(d);
			conn = DriverManager.getConnection("jdbc:odbc:ORCL", "employees_admin", "employees_admin");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		System.out.println(conn);
//		System.out.println(System.getProperty("java.class.path"));
	}

}
