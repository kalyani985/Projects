<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="add" value="/item/show" />
     <a href="${add}" >LIBRARY ITEMS</a>
	<table border="1">
		<tr>
		    <td>ITEM ID </td>
			<td>ITEM TITLE</td>
			<td>AUTHOR</td>
			<td>PUBLISHER</td>			
			<td>STATUS</td>
			<td>CATEGORY </td>
			
		</tr>
		<c:forEach  items="${itemlist}" var="it" varStatus="i">
			<tr> 
			 
				<td>${it.item_id}</td>
				<td>${it.item_title}</td>
				<td>${it.item_author}</td>
				<td>${it.item_publisher}</td>				
				<td>${it.item_status}</td>
				<td>${it.item_category}</td>
				
				<td> Edit</td>
				<td> 
				
				   <c:url var="del" value="/item/delete">
				      <c:param name="id" value="${student.id}"/>
				   </c:url>
				   <a href="${del}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>



     
