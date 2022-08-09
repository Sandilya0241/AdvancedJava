package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseValidationServlet
 */
public class CourseValidationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("TXT_ID"));
		String name = req.getParameter("TXT_NAME");
		double fee = Double.parseDouble(req.getParameter("TXT_FEE"));
		
		PrintWriter out = resp.getWriter();
		out.print("Id : " + id);
		out.print("Name : " + name);
		out.print("Fee : " + fee);
	}
}
