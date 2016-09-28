<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New User: Choose Type</title>
</head>
<body>
	<h1>Choose User Type to Create New User</h1><br/>
	<h2><a href="<%=request.getContextPath()%>/UserDetails/newStudent">Student</a></h2><br/>
	<h2><a href="<%=request.getContextPath()%>/UserDetails/newLibrarian">Librarian</a></h2><br/>
</body>
</html>