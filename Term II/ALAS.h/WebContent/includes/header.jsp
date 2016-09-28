<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>

<table>
	<tr>
		<td><img src="${pageContext.request.contextPath}/img/${book.id}}.jpg"
			width="100" height="100" alt="DEMO" border="0"></td>
		<td><h1 align="center">${sessionScope.profile.name}PlaceHolder for Header</h1></td>
		
	</tr>
</table>


</body>
</html>