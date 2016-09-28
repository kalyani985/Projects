<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User Page</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/UserDetails/searchuser" method="post">

		Search by: <br /> <input type="radio" name="radioitem" value="user_id" />
		User Id <input type="radio" name="radioitem" value="user_name" checked="checked"/> 
		User Name <input type="text" name="item_text" /> 
		<input type="submit" name="search" value="Search" />

	</form>

	<c:if test="${searchlist}">
		<table border="1">
			<tr>
				<td>User Id:</td>
				<td>User Name:</td>
				<td>User Address:</td>
				<td>User Contact:</td>
				<td>User Gender:</td>
				<td>User Status:</td>
			</tr>
			<c:forEach items="${searchlist}" var="student" varStatus="i">
				<tr>
					<td>${user.user_id}</td>
					<td>${user.user_name}</td>
					<td>${user.user_address}</td>
					<td>${user.user_contact}</td>
					<td>${user.user_gender}</td>
					<td>${user.user_status}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>