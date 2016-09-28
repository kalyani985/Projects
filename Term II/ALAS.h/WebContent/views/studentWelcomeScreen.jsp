<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Welcome Screen</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Item ID</td>
			<td>Item Category</td>
			<td>Item Name</td>
			<td>Item Status</td>
			<td>Date To Be Returned</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${tlist}" var="tran" varStatus="i">
			<tr>
				<td>${tran.item_id}</td>
				<td>${tran.item_category}</td>
				<td>${tran.item_title}</td>
				<td>${tran.item_status}</td>
				<td>${tran.item_due_date}</td>
				<td>Return</td> <!-- h: Return to be a link to Prabha's code -->
			</tr>
		</c:forEach>
	</table>
</body>
</html>
