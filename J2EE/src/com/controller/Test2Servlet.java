package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test2Servlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		String name = req.getParameter("TXT_NAME");
		String password = req.getParameter("TXT_PWD");
		resp.setContentType("text/html");
		hs.setAttribute("username", name);
		hs.setAttribute("password", password);
		resp.getWriter().println("Success <br>"
				+ "<a href='./logout'>Log Out</a>");
	}
}
