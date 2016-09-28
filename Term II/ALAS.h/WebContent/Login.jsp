<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.auto-style1 {
	text-align: center;
}

.auto-style2 {
	text-align: center;
	font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
		sans-serif;
	font-size: xx-large;
}

.auto-style3 {
	margin-left: 44px;
	margin-top: 46px;
}

.auto-style4 {
	font-size: large;
}

.auto-style5 {
	margin-left: 26px;
}

.auto-style6 {
	margin-top: 39px;
}
</style>
</head>
<body>
	<img alt="" class="auto-style5" height="82"
		src="${pageContext.request.contextPath}/img/NUSLOGO.png"
		style="float: left" width="144" />
	<p class="auto-style1">&nbsp;</p>
	<p class="auto-style1">&nbsp;</p>
	<%-- <img src="${pageContext.request.contextPath}/img/NUSLOGO.png" alt="" height="82" width="144" /> --%>
	<p class="auto-style2">
		<strong>ALAS Login</strong>
	</p>
	<h2 style="text-align: center;">${message}</h2>
	<form action="<%=request.getContextPath()%>/login/validateuser"
		method="post">
		<p class="auto-style2">
			<span class="auto-style4">UserID:</span> <input class="auto-style3"
				name="username" style="height: 41px; width: 242px" type="text">
		</p>
		<p class="auto-style2">
			<label id="Label1"><span class="auto-style4">Password:&nbsp;&nbsp;&nbsp;</span></label>
			<input class="auto-style5" name="password"
				style="height: 39px; width: 250px" type="password">
		</p>
		<p class="auto-style2">
			<strong> <input class="auto-style6" name="submit"
				style="height: 42px" type="submit" value="SUBMIT"></strong>
		</p>
	</form>
	<p class="auto-style2">&nbsp;</p>
	<p class="auto-style2">&nbsp;</p>
</body>
</html>