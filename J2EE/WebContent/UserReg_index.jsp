<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<form action="UserReg_process.jsp">
		<table>
			<tr>
				<td>Name </td>
				<td><input type="text" name="strUserName" onclick="this.value=''"/></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="text" name="strUserEMail" onclick="this.value=''"/></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="strUserPasswd" onclick="this.value=''"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>
<!-- 
	CREATE TABLE  "USER432"   
   (    "NAME" VARCHAR2(4000),   
    "EMAIL" VARCHAR2(4000),   
    "PASS" VARCHAR2(4000)  
   )  

 -->