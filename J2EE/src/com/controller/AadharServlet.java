package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AadharServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		String frmType = req.getParameter("formtype");
		System.out.println("doPost Called");
		if(frmType.equals("APPLICANT_INFO_PAGE")) {
			String name = req.getParameter("TXT_NAME");
			String fatherName = req.getParameter("TXT_FNAME");
			String motherName = req.getParameter("TXT_MNAME");
			hs.setAttribute("name", name);
			hs.setAttribute("fatherName", fatherName);
			hs.setAttribute("motherName", motherName);
			resp.sendRedirect("./AadharForm2.html");

		} else if(frmType.equals("EDU_DETAILS_PAGE")) {

			String qual = req.getParameter("TXT_QUAL");
			try {
				float per = Float.parseFloat(req.getParameter("TXT_PRTG"));
				hs.setAttribute("per", per);
			} catch (Exception e) {
				resp.sendRedirect("./AadharForm2.html");
			}
			
			hs.setAttribute("qual", qual);			
			resp.sendRedirect("./AadharForm3.html");
		} else {
			PrintWriter out = resp.getWriter();
			
			String name = (String)hs.getAttribute("name");
			String fatherName = (String)hs.getAttribute("fatherName");
			String motherName = (String)hs.getAttribute("motherName");
			
			String qual = (String)hs.getAttribute("qual");
			float per = (float)hs.getAttribute("per");
						
			String contact = req.getParameter("TXT_CNTCT");
			String email = req.getParameter("TXT_EMAIL");
			String address = req.getParameter("TXT_ADDR");
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclgdb", "employees_admin", "employees_admin");
				PreparedStatement pst = conn.prepareStatement("INSERT INTO AADHARDETAILS VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				pst.setString(1, name);
				pst.setString(2, fatherName);
				pst.setString(3, motherName);
				pst.setString(4, qual);
				pst.setFloat(5, per);
				pst.setString(6, contact);
				pst.setString(7, email);
				pst.setString(8, address);
				
				int cnt = pst.executeUpdate();
				
				if(cnt > 0) {
					out.println("<pre>");
					out.println("name : " +name);
					out.println("fatherName : " +fatherName);
					out.println("motherName : " +motherName);
					out.println("qual : " +qual);
					out.println("per : " +per);
					out.println("contact : " +contact);
					out.println("email : " +email);
					out.println("address : " +address);
					out.println("</pre>");	
					
					out.println("<font color='green'><h1>Course registration Successful</h1></font>"
							+ "<br><a href=\"./index.html\">Go back to form</a>");
				} else {
					out.println("<font color='red'><h1>Course registration failed</h1></font>"
							+ "<br><a href=\"./index.html\">Go back to form</a>");
				}
				if(conn !=  null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<font color='red'><h1>Course registration failed</h1></font>"
						+ "<br><a href=\"./index.html\">Go back to form</a>");
			}
		}
	}
	
}

/*
 * create table aadhardetails (
 * name varchar2(30),
 * fathername varchar2(30),
 * mothername varchar2(30),
 * qualification varchar2(15), 
 * percentage number(5,2),
 * contact varchar2(15),
 * email varchar2(20), 
 * address varchar2(255)
 * );
 */