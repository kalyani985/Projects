<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ALAS Login Page</title>
</head>
<body>
    <h1 align="left">ALAS Login Page</h1>
    <h2>${message}</h2>
    <form action="/alas/login/validateuser" method="post">
	<table width="80%"> 
		<tr>
			<td width="30%">User Name:</td>
			<td><input type="text" name="username" size=25 maxlength=30/>
			</td>
		</tr>
		<tr>
			<td width="30%">User Password:</td>
			<td><input type="password" name="password" size=25 maxlength=30/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="SUBMIT"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="reset" value="RESET"/></td>
		</tr>
	</table>
	</form>
	<!-- Temporary link below -->
	<c:url var="search" value="/item/temp"/>
	<h3><a href="${search}">Librarian Search Page</a></h3>
	<!-- end Temporary link -->
</body>
</html>