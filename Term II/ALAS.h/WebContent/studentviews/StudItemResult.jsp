<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Search Results Page</title>
</head>
<body>

    <c:if test = "${empty success}"> 
	<table border="1">
		<tr>
		    <td>ITEM ID </td>
			<td>ITEM TITLE</td>
			<td>AUTHOR</td>
			<td>PUBLISHER</td>			
			<td>STATUS</td>
			<td>CATEGORY </td>
			<td>ACTION</td>
			<!-- <td>TRANSACTION</td> -->
			
		</tr>
		<c:forEach  items="${itemlist}" var="it" varStatus="i">
			<tr> 
			 
				<td>${it.item_id}</td>
				<td>${it.item_title}</td>
				<td>${it.item_author}</td>
				<td>${it.item_publisher}</td>				
				<td>${it.item_status}</td>
				<td>${it.item_category}</td>
												
				<td> <c:url var="uinserttrans" value="/item/uinserttrans">
				<c:param name = "itemid" value="${it.item_id}"/>
				<c:param name = "title" value="${it.item_title}"/>
				<c:param name = "author" value="${it.item_author}"/>
				<c:param name = "publisher" value="${it.item_publisher}"/>
				<c:param name = "status" value="${it.item_status}"/>
				<c:param name = "published_year" value="${it.item_published_year}"/>
				<c:param name = "ISBN" value="${it.item_ISBN}"/>
				<c:param name = "description" value="${it.item_description}"/>
				
				
				</c:url>
				
				<a href="${uinserttrans}">BORROW</a></td>
				
			</tr>
		</c:forEach>
	</table>
	
	</c:if>
<label>${success}</label>
<label>${finemsg}</label>
<label>${errorMsg}</label>
</body>
</html>



     
