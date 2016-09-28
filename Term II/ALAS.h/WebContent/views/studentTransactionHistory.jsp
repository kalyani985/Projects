<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Transaction History Screen</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Item ID</td>
			<td>Item Category</td>
			<td>Item Name</td>
			<td>Date Borrowed</td>
			<td>Date Returned</td>
			<td>Item Status</td>
			<td>Fine Amount</td>
			<td>Paid?</td>
		</tr>
		<c:forEach items="${hlist}" var="tran" varStatus="i">
			<tr>
				<td>${tran.item_id}</td>
				<td>${tran.item_category}</td>
				<td>${tran.item_title}</td>
				<td>${tran.item_issue_date}</td>
				<td>${tran.item_return_date}</td>
				<td>${tran.item_status}</td>
				<td>${tran.trans_fine_amount}</td>
				<td>Yes/No/Blank</td> <!-- h: Yes-if fine paid, No-if fine not paid, Blank-no fine incurred -->
			</tr>
		</c:forEach>
	</table>
</body>
</html>
