package com.learnjava.advancedjava;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Test1ExampleDB {
	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Enumeration enumDriverManagers = DriverManager.getDrivers();
		while(enumDriverManagers.hasMoreElements()) {
			Driver d = (Driver)enumDriverManagers.nextElement();
			System.out.println("" + d.getClass().getName());
		}
	}
}
