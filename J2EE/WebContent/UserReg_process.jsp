<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Process Request</title>
</head>
<body>
	<%@ page import="userregbean.RegisterDao" %>
	<jsp:useBean id="obj" class="userregbean.User"></jsp:useBean>
	<jsp:setProperty property="*" name="obj"/>
	<%
		int status = 0;
		status = RegisterDao.register(obj);
		if(status > 0) {
			out.println("Register Succesful");
		}
	%>
</body>
</html>