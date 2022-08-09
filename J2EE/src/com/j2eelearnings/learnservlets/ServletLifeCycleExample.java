package com.j2eelearnings.learnservlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletLifeCycleExample implements Servlet {

	public ServletLifeCycleExample() {
		System.out.println("ServletLifeCycleExample object created!!!");
	}
	
	@Override
	public void destroy() {
		System.out.println("ServletLifeCycleExample during destroy!!!");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("ServletLifeCycleExample during Init!!!");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("ServletLifeCycleExample during Service!!!");
	}

}
