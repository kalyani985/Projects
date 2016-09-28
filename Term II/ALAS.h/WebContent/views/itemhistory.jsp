<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian's View Item History Page</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Transaction ID</td>
			<td>User ID</td>
			<td>Item ID</td>
			<td>Transaction Details</td>
			<td>Item Issue Date</td>
			<td>Item Due Date</td>
			<td>Item Return Date</td>
			<td>Fine Amount</td>
		</tr>
		<c:forEach items="${translist}" var="trans" varStatus="i">
			<tr>

				<td>${trans.trans_id}</td>
				<td>${trans.user_id}</td>
				<td>${trans.item_id}</td>
				<td>${trans.trans_details}</td>
				<td>${trans.item_issue_date}</td>
				<td>${trans.item_due_date}</td>
				<td>${trans.item_return_date}</td>
				<td>${trans.trans_fine_amount}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>