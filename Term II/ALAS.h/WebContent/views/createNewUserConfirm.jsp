<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New User Confirm</title>
</head>
<body>
		<h3>Create New ${newUserType} Profile</h3><br /> 
		<h2>${message}</h2><br /> 
		User Id: ${newUser.user_id} <br /> <br /> 
		User Name: ${newUser.user_name} <br /> <br /> 
		User Address: ${newUser.user_address} <br /> <br /> 
		User Contact: ${newUser.user_contact} <br /> <br /> 
		User Gender: ${newUser.user_gender} <br /> <br /> 
 		Account Password: ${newUser.user_password} <br /> <br />
</body>
</html>