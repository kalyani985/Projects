<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New User Profile</title>
</head>
<body>
	<form action="/alas/UserDetails/create" method="post">
		<h3>Create New ${newUserType} Profile</h3><br /> 
		<h2>${message}</h2><br /> 
		User Id: <input type="text" name="id" value="${newUserID}" readonly/> <br /> <br /> 
		User Name: <input type="text" name="name" /> <br /> <br /> 
		User Address: <input type="text" name="address" /> <br /> <br /> 
		User Contact: <input type="text" name="contact" /> (max 8 digits only)<br /> <br /> 
		User Gender: <select name="gender">
		<option value="Other" disabled selected>Choose One</option>
		<option value="F">Female</option>
		<option value="M">Male</option>
		</select> <br /> <br /> 
 		Account Password: <input type="text" name="password" /> (max. 6 characters)<br /> <br />
 		<input type="hidden" name="userType" value="${newUserType}" />
		<input type="submit" value="Create" />
		<input type="reset" value="Reset" />
	</form>
</body>
</html>