
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValServlet  extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("TXT_NAME");
		String email = req.getParameter("TXT_EMAIL");
		String address = req.getParameter("TXT_ADDR");
		try {
			boolean isValid = true;
			if(name == "") {
				out.println("<font color='red'><h1>Name field missing. Please provide name.</h1></font><br>"
						+ "<a href='./Home.html'>Go back</a>");
				isValid = false;
			}
			if(email == "") {
				out.println("<font color='red'><h1>Email field missing. Please provide email.</h1></font><br>"
						+ "<a href='./Home.html'>Go back</a>");
				isValid = false;
			}
			if(address == "") {
				out.println("<font color='red'><h1>Address field missing. Please provide address.</h1></font><br>"
						+ "<a href='./Home.html'>Go back</a>");
				isValid = false;
			}
			if(isValid) {
//				RegisterServlet rs = (RegisterServlet)req.getServletContext().getServlet("com.controller.RegisterServlet");
//				rs.doGet(req, resp);
				RequestDispatcher rd = req.getRequestDispatcher("/register");
				rd.forward(req, resp);
			}
			else {		
			}
		} catch (Exception e) {
		}
	}
}