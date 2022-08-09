package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CourseRegistrationServlet  extends GenericServlet {
	private Connection conn;
	public void init(ServletConfig config) throws ServletException {
		ServletContext sctxt = config.getServletContext();
		String driver = sctxt.getInitParameter("driver");
		String url = sctxt.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			
		}
	}
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		int id = Integer.parseInt(req.getParameter("TXT_ID"));
		String name = req.getParameter("TXT_NAME");
		Double fee = Double.parseDouble(req.getParameter("TXT_FEE"));
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO COURSE VALUES (?, ?, ?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDouble(3, fee);
			/*
			 * 
			 * create table course (id number, name varchar2(255), fee number(8,2))
			 */
			int count = pst.executeUpdate();
			System.out.println(count);
			if(count > 0) {
				out.println("<font color='green'><h1>Course registration successfully</h1></font>"
						+ "<br><a href=\"./index.html\">Go back to form</a>");
			}
		} catch (SQLException e) {
			out.println("<font color='red'><h1>Error while executing the DB statement</h1></font>"
					+ "<br><a href=\"./index.html\">Go back to form</a>");
		}
	}
	
	public void destroy() {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
