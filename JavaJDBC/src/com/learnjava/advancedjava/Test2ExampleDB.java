package com.learnjava.advancedjava;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import sun.jdbc.odbc.JdbcOdbcDriver;

public class Test2ExampleDB {

	public static void main(String[] args) {
		Driver d = new JdbcOdbcDriver();
		try {
			DriverManager.registerDriver(d);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		Enumeration e = DriverManager.getDrivers();
		while(e.hasMoreElements()) {
			Driver mydr = (Driver)e.nextElement();
			System.out.println(mydr.getClass().getName());
		}
	}

}
