package com.controller;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Test3 implements ServletRequestListener{
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request Destryed");
	}
	
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request Created");
	}
}
