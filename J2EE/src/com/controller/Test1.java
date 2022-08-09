package com.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Test1 implements ServletContextListener{
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context Listener Initialized");
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Listener Destroyed");
	}
}
