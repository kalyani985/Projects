<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SEARCH BY</title>
</head>
<body>
	<h1>SEARCH BY</h1>
	<form action="<%=request.getContextPath()%>/item/usearch" method="post">

		<input type="radio" name="radioitem" value="category" /> Category <br />
		<br />
		<br /> <input type="radio" name="radioitem" value="item_id" checked="checked" /> Item	ID: <br />
		<br />
		<br /> <input type="radio" name="radioitem" value="title" /> Title <br />
		<br />
		<br /> <input type="radio" name="radioitem" value="author" /> Author <br />
		<br />
		<br /> <input type="text" name="item_text" /> 
		<input type="submit" value="SEARCH" /> 
		<input type="reset" value="RESET" />
	</form>
</body>
</html>