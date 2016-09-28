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

	<form action="<%=request.getContextPath()%>/item/inserttrans" method="post">
		<input type="hidden" name="studentid" value="${studentid }" /> Item ID
		<input type="text" name="itemid" value="${itemid}" /> <br />
		<br /> Item Title <input type="text" name="itemtitle"
			value="${itemtitle}" /> <br />
		<br /> Item Category <input type="text" name="itemcategory"
			value="${itemcategory}" /> <br />
		<br /> Item Publisher <input type="text" name="itempublisher"
			value="${itempublisher}" /> <br />
		<br /> Item Published Date <input type="text" name="itempublisheddate"
			value="${itempublisheddate}" /> <br />
		<br /> ISBN <input type="text" name="isbn" value="${isbn}" /> <br />
		<br /> Item Description <input type="text" name="itemdescription"
			value="${itemdescription}" /> <br />
		<br /> Item Status <input type="text" name="itemstatus"
			value="${itemstatus}" /> <br />
		<br />
		<!-- <tr> -->
			<!-- <td colspan="2" align="center"> -->
			<input type="submit" value="SUBMIT" />
			<!-- </td> -->
		<!-- </tr> -->
	</form>
	<br />
	<br />
	<!--  <form  action="/views/borrowitem.jsp" method="post">-->
	<!--   <tr> <td colspan ="2" align ="center"> <input type="submit" value="BORROW AGAIN"/> </td></tr> -->
	<!--  </form><br/><br/><form action="/views/index.jap" method="post"> -->
	<!-- <tr> <td colspan ="2" align ="center"> <input type="submit" value="HOME"/> </td></tr> </form>-->
	<c:url var="borag" value="/views/borrowitem.jsp" />
	<a href="${borag}"> Borrow Again </a> &nbsp;

	<c:url var="home" value="/item/index.jsp" />
	<a href="${home}"> HOME </a> &nbsp;

	<label>${success}</label>
	<label>${errorMsg}</label>

</body>
</html>