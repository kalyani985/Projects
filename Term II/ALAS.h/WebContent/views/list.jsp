<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<h1>Library User Details</h1>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Contact Number</td>
			<td>Address</td>
			<td>Status</td>
			
			<td>Edit</td>
			<td>Transactions</td>
		</tr>
		<c:forEach items="${ulist}" var="user">
			<tr>
				<td>${user.user_id}</td>
				<td>${user.user_name}</td>
				<td>${user.user_gender}</td>
				<td>${user.user_contact}</td>
				<td>${user.user_address}</td>
				<td>${user.user_status}</td>

				<td><c:url var='edit' value="/UserDetails/edit">
						<c:param name="id" value="${user.user_id}" />
						<c:param name="name" value="${user.user_name}" />
						<c:param name="address" value="${user.user_address}" />
						<c:param name="contact" value="${user.user_contact}" />
						<c:param name="gender" value="${user.user_gender}" />
						<c:param name="status" value="${user.user_status}" />
					</c:url> 
					<a href="${edit}">Edit</a>
				</td>
				<td>
					<c:url var='history' value="/UserDetails/studtranhist">
						<c:param name="h_id" value="${user.user_id}" />
					</c:url>
					<a href="${history}">History</a>
				</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>