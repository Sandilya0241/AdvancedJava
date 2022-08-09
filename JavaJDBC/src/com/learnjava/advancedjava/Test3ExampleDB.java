package com.learnjava.advancedjava;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.*;

public class Test3ExampleDB {

	public static void main(String[] args) {
		System.out.println("Main");
		Enumeration e = DriverManager.getDrivers();
		while(e.hasMoreElements()) {
			Driver d = (Driver)e.nextElement();
			System.out.println(d.getClass().getName());
		}
	}
}

/*
 * javac  -d  . Test3ExampleDB.java
 * java -Djdbc.drivers="sun.jdbc.odbc.JdbcOdbcDriver" com.learnjava.advancedjava.Test3ExampleDB
 */