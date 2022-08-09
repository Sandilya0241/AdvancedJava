package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		System.out.println(name);
		System.out.println(email);
		System.out.println(address);
		out.println("<Pre>"
				+ "name : " + name
				+ "email : " + email
				+ "address" + address
				+ "</Pre>");
	}
}
