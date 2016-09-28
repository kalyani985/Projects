<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian's Return Item Page: Scan StudentID</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/item/nextcheck" method="post">
		Student ID <input type="text" name="studentid" /> <br /> <br /> 
		<input type="submit" value="NEXT" />
	</form>
</body>
</html>