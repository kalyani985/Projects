<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian's Maintain User Page</title>
</head>




<form action="<%=request.getContextPath()%>/UserDetails/update"
	method="post">

	<h2>Maintain Student Profile</h2><br /> 
	Student ID: <input type="text" name="id" <%-- value="${user.user_id}" --%> placeholder="${user.user_id}" disabled="disabled" readonly /> 
	<input type="hidden" name="idhidden" value="${user.user_id}" /> <br /> <br /> 
	Student Name: <input type="text" name="name" value="${user.user_name}" /> <br /> <br />
	Student Address: <input type="text" name="address" value="${user.user_address}" /> <br /> <br /> 
	Student Contact: <input	type="text" name="contact" value="${user.user_contact}" /> <br /> <br />
	Student Gender: <input type="text" name="gender" value="${user.user_gender}" /> <br /> <br /> 
	Student Status: <%-- <input type="text" name="status" value="${user.user_status}" /> --%> 
	<select name="status">
        <option value="Active" <c:if test="${user.user_status == 'Active'}">selected</c:if>>Active</option>
        <option value="Inactive" <c:if test="${user.user_status == 'Inactive'}">selected</c:if>>Inactive</option>
    </select>
	<br /> <br />
	<input type="submit" name="button" value="Update" /> 
	<input type="submit" name="button" value="Delete" />


</form>
</body>
</html>