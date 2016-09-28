<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian's Return Item Page: Choose Item</title>
</head>
<body>
	<%-- <c:url var="add" value="/item/show" />
	<a href="${add}">LIBRARY ITEMS</a> --%>

	<table border="1">
		<tr>
			<td>TRANS ID</td>
			<td>ITEM ID</td>
			<td>TRANS DETAILS</td>
			<td>DATE TO BE RETURNED</td>
			<td>RETURN</td>
			<td>RENEW</td>
		</tr>
		<c:forEach items="${translist}" var="it" varStatus="i">
			<tr>
				<td>${it.trans_id}</td>
				<td>${it.item_id}</td>
				<td>${it.trans_details}</td>
				<td>${it.item_due_date}</td>

				<td><c:url var="ret" value="/item/return">
						<c:param name="transid" value="${it.trans_id}" />
						<c:param name="transduedate" value="${it.item_due_date}" />
						<c:param name="itemid" value="${it.item_id}" />
					</c:url> 
					<a href="${ret}">Return</a> 
				</td>
				<td>
					<%-- <c:url var="del" value="/item/delete">
						<c:param name="id" value="${student.id}" />
					</c:url> --%> 
					<a <%-- href="${del}" --%>>Renewal</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>