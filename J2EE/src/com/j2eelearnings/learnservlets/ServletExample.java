package com.j2eelearnings.learnservlets;

import javax.servlet.*;
import java.io.*;

public class ServletExample implements Servlet{
	ServletConfig config = null;
	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "This is test servlet";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("TXT_NAME");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html>"
				+ "<head>"
				+ "<title>"
				+ "First Servlet Response"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Hello : " + name + "</h1>"
				+ "</body>"
				+ "</html>");
		out.close();
	}
}
