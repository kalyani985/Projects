<?xml version="1.0" encoding="UTF-8" ?>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-sg" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Home&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Welcome</title>
<style type="text/css">
.auto-style2 {
	font-size: medium;
	font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
		sans-serif;
}

.auto-style3 {
	font-size: xx-large;
	font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
		sans-serif;
}

.auto-style4 {
	font-size: large;
	font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
		sans-serif;
}

.auto-style5 {
	margin-top: 0px;
}
}
</style>
</head>

<body style="margin-left: 7px">

	<br />
	<label id="Label1"><span class="auto-style2"> <img
			alt="" class="auto-style5" height="165"
			src="${pageContext.request.contextPath}/img/NUSLOGO.png"
			style="float: left" width="288" /></span></label>
	<br />
	<br />
	<br />
	<label id="Label1"><span class="auto-style3">&nbsp; ALL
			LIBRARY ACCESS SYSTEM&nbsp; </span><span class="auto-style2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/login/listonloanitems">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</span></label>
	<span class="auto-style2">Welcome <strong><%= session.getAttribute("loginUserName") %></strong></span>
	<span class="auto-style4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/login/logoutuser">Logout</a>
	</span>
	<hr />
	<table width="100%">
		<tr>
			<td width="45%">
				<div id="layer1"
					style="position: absolute; width: 200px; height: 471px; z-index: 1; left: 9px; top: 233px">
					<br /> <br /> <strong>Library Item</strong>
					<hr />
					<span class="auto-style2">
					<a href="<%=request.getContextPath()%>/login/listonloanitems">Return Item</a><br /> 
					<a href="<%=request.getContextPath()%>/studentviews/StudSearch.jsp">Search / Borrow Item</a><br /> 
					<a href="<%=request.getContextPath()%>/login/studtranhist">Transaction History</a>
					</span>
					<br /> <br /> <br />
				</div>
			</td>
			<td width="55%"><decorator:body /></td>
		</tr>
	</table>

</body>

</html>