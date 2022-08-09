package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CourseValidationFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		String filterParam = filterConfig.getInitParameter("filterVal");
		System.out.println(filterParam);
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		int id = 0;
		double fee = 0;
		try {
			id = Integer.parseInt(request.getParameter("TXT_ID"));
		} catch (Exception e) {
		}
		String name = request.getParameter("TXT_NAME");
		try {
			fee = Double.parseDouble(request.getParameter("TXT_FEE"));
		} catch (Exception e) {
		}
		
		
		if(id <= 0) {
			out.print("Invalid data provided in ID field");
		} else if(name.equals("")) {
			out.print("Invalid data provided in Name field");
		}else if(fee <= 0.0) {
			out.print("Invalid data provided in Fee field");
		}
		else {
			out.println("<div style='border: dashed;border-color: red;color: green;font-size: 30px;'>");
			out.println("<Pre>");
			chain.doFilter(request, response);
			out.println("</Pre>");
			out.println("</div>");
		}
	}
}
