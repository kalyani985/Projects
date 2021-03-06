<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian's Create Item Page: Fill In Details</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/item/icreate" method="post">

		<h1> Maintain Library Item </h1>
		<table>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<td>Category</td>
				<td><select name="category">
						<option value="book">Book</option>
						<option value="cd">CD</option>
						<option value="cassette">Cassette</option>
						<option value="kits">Kits</option>
						<option value="manuscript">Manuscript</option>
						<option value="magazine">Magazine</option>
						<option value="journal">Journal</option>
				</select></td>
			</tr>

			<tr>
				<td>Author</td>
				<td><input type="text" name="author" /></td>
			</tr>

			<tr>
				<td>Publisher</td>
				<td><input type="text" name="publisher" /></td>
			</tr>

			<tr>
				<td>Published Year</td>
				<td><input type="text" name="published_year" /></td>
			</tr>


			<tr>
				<td>ISBN</td>
				<td><input type="text" name="isbn" /></td>
			</tr>


			<tr>
				<td>Description</td>
				<td rowspan="4"><input type="text" name="description">
				</td>
			</tr>



		</table>

		<!-- <tr>
			<td colspan="2" align="center"> -->
			<input type="submit" name="itemCreate" value="CREATE" />
			<!-- </td>
		</tr> -->

		<!-- <tr>
			<td colspan="2" align="center"> -->
			<input type="reset" value="RESET" />
			<!-- </td>
		</tr> -->


	</form>
</body>
</html>
