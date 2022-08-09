package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 
 * create table regtable (
 * name varchar2(30),
 * email varchar2(30),
 * address varchar2(255)
 * );
 * 
 */
public class RegisterServlet extends HttpServlet{
	private Connection conn;
	public void init(ServletConfig config) throws ServletException {
		ServletContext sctxt = config.getServletContext();
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		String driverName = sctxt.getInitParameter("driver");
		String url = sctxt.getInitParameter("url");
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("TXT_NAME");
		String email = req.getParameter("TXT_EMAIL");
		String address = req.getParameter("TXT_ADDR");
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO REGTABLE VALUES (?, ?, ?)");
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, address);
			int cnt  = pst.executeUpdate();
			
			if(cnt > 0) {
				out.println("<font color='green'><h1>Fields updation successful.</h1></font><br>"
						+ "<a href='./Home.html'>Go back</a>");
			} else {
				out.println("<font color='red'><h1>Fields updation failed due to techincal error.</h1></font><br>"
						+ "<a href='./Home.html'>Go back</a>");
			}
		} catch (Exception e) {
			out.println("<font color='red'><h1>Fields updation failed due to techincal error.</h1></font><br>"
					+ "<a href='./Home.html'>Go back</a>");
			e.printStackTrace();
		}
	}
}
