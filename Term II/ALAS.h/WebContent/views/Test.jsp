<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <c:url var="tListItem" value="/tListItem">
<c: param name = "item_id" value = "${items.item_id}"/>
</c:url>
 --%>
 <a href = "${tListItem}">Transaction History by Item ID</a>

<%-- <c:url var="tListUser" value="/tListUser">
<c: param name = "user_id" value = "${user.user_id}"/>
</c:url> --%>
<a href = "${tListUser}">Transaction History by User ID</a>

</body>
</html>