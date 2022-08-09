package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ColorAppndrServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// by Pattern
//		RequestDispatcher rd = req.getRequestDispatcher("/GreetHelloServ");
		RequestDispatcher rd = getServletContext().getNamedDispatcher("GreetHelloServ");

		out.println("<body style='background-color:red;'>");
		System.out.println("Calling GreetHelloServlet"); 
		rd.include(req, resp);
		out.println("</body>");	
	}
}