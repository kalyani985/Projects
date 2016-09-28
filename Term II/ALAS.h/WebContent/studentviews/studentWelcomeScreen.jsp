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
<h3 style="text-align:center;">You have ${tSize} items on loan.</h3>
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
				<td><c:url var="ret" value="/item/stdreturn">
				<%-- <td><c:url var="ret" value="/item/return"> --%>
						<c:param name="transid" value="${tran.trans_id}" />
						<c:param name="transduedate" value="${tran.item_due_date}" />
						<c:param name="itemid" value="${tran.item_id}" />
						<c:param name="transdetails" value="${tran.trans_details}" />
					</c:url> 
					<a href="${ret}">Return</a></td> <!-- h: Return to be a link to Prabha's code -->
			</tr>
		</c:forEach>
	</table>
</body>
</html>
