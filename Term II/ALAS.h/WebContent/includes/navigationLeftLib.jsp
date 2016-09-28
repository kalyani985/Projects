<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Left Navigation - Librarian</title>
</head>

<body>
<h2>Library Item</h2>
	<ul>
		<li><a href="<%=request.getContextPath()%>/views/itemsearch.jsp">Search / Maintain / Transaction History</a></li>
		<li><a href="<%=request.getContextPath()%>/views/createItem.jsp">Create</a></li>
		<li><a href="<%=request.getContextPath()%>/views/LibrarianReturn.jsp">Return</a></li>
		<li><a href="<%=request.getContextPath()%>/views/borrowitem.jsp">Borrow</a></li>
		<!-- <li><a href="/views/page1.jsp">Transaction History</a></li> -->
	</ul>

<h2>Student Profile</h2>
	<ul>
		<li><a href="<%=request.getContextPath()%>/views/SearchStudent.jsp">Search / Maintain / Transaction History</a></li>
		<li><a href="<%=request.getContextPath()%>/views/chooseUserType.jsp">Create</a></li>
		<%-- <li><a href="<%=request.getContextPath()%>/login/studtranhist">Transaction History</a></li> --%>	
	</ul>	

</body>
</html>