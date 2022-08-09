package com.j2eelearnings.learnservlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class testJDBC {

	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("C:\\Users\\saakh\\eclipse-workspace\\JavaWebApplications\\src\\com\\j2eelearnings\\learnservlets\\resources\\MyProperties.properties"));
		} catch (IOException ioe) {
			System.out.println("<font color='red'><h1>ISSUE WHILE LOADING PROPERTY FILE"+ioe.getMessage()+"</h1></font>" );
		}
		System.out.println(p.get("user"));
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("<font color='red'><h1>ISSUE WHILE LOADING DRIVER CLASS * " + cnfe.getMessage() + "</h1></font>");
		}
		try {
			conn = DriverManager.getConnection(p.getProperty("url"),p);
			System.out.println("Degub point");
			PreparedStatement pst =  conn.prepareStatement("INSERT INTO EMP1 VALUES (?,?,?,?)");
			pst.setInt(1, 1);
			pst.setString(2, "ABC");
			pst.setString(3, "DECSA");
			pst.setDate(4, java.sql.Date.valueOf("2020-08-08"));
			int i = pst.executeUpdate();
			if(i > 0) {
				System.out.println("<font color='green'><h1>DATA INSERTED SUCCESSFULLY</h1></font>");
			}
			
		} catch (SQLException sqle) {
			System.out.println("<font color='red'><h1>ISSUE WHILE DOING SQL OPERATION "+ sqle.getMessage() + "</h1></font>");
		}
		try {
			if(conn != null && conn.isClosed() != true) {
				conn.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
