package com.j2eelearnings.learnservlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletExample extends GenericServlet {

	public GenericServletExample() {
		System.out.println("ServletLifeCycleExample object created!!!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("DFR!!!");
		int id = 0;
		String name = "", deptname = "", dob = "";
		PrintWriter out = res.getWriter();
		try {
			id = Integer.parseInt(req.getParameter("TXT_ID"));
			name = req.getParameter("TXT_NAME");
			deptname = req.getParameter("TAR_DEPT");
			dob = req.getParameter("DAT_DOB");
			
		} catch (Exception e) {
			out.println("<font color='red'><h1>ISSUE WHILE PARSING INPUT " +e.getMessage() + "</h1></font>");
		}
		
		
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("C:\\Users\\saakh\\eclipse-workspace\\JavaWebApplications\\src\\com\\j2eelearnings\\learnservlets\\resources\\MyProperties.properties"));
		} catch (IOException ioe) {
			out.println("<font color='red'><h1>ISSUE WHILE LOADING PROPERTY FILE"+ioe.getMessage()+"</h1></font>" );
		}
		System.out.println(p.get("user"));
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			out.println("<font color='red'><h1>ISSUE WHILE LOADING DRIVER CLASS * " + cnfe.getMessage() + "</h1></font>");
		}
		try {
			conn = DriverManager.getConnection(p.getProperty("url"),p);
			System.out.println("Degub point");
			PreparedStatement pst =  conn.prepareStatement("INSERT INTO EMP1 VALUES (?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, deptname);
			pst.setDate(4, java.sql.Date.valueOf(dob));
			int i = pst.executeUpdate();
			if(i > 0) {
				out.println("<font color='green'><h1>DATA INSERTED SUCCESSFULLY</h1></font>");
			}
			
		} catch (SQLException sqle) {
			out.println("<font color='red'><h1>ISSUE WHILE DOING SQL OPERATION "+ sqle.getMessage() + "</h1></font>");
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
