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
             
public class StudentRegistrationServlet extends GenericServlet {
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
		String email = req.getParameter("TXT_EMAIL");
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO STUDENT VALUES (?, ?, ?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, email);
			/*
			 * 
			 * create table student (id number, name varchar2(255), email varchar2(255))
			 */
			int count = pst.executeUpdate();
			System.out.println(count);
			if(count > 0) {
				out.println("<font color='green'><h1>Successfully updated</h1></font>"
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
