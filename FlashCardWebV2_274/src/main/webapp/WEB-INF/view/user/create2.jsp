<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/EvenTable.css">
</head>
<body>
	<h1>CREATE USER 2</h1>
	<hr>
	<input type="text" value="tk123456" name="aatoken"></input>
	<form action="${pageContext.request.contextPath}/user?aatoken=tk123456"
		method="POST">
		<table class="evenTable">
			<tr>
				<td><font size="6" color="blue">CREATE USER</font></td>
				<td style="text-align: right"><a
					href="${pageContext.request.contextPath}/index.jsp"><font
						size="5" color="BlueViolet">cencel</font> </a></td>
			</tr>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" value="${user.username}" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="${user.password}" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="display_name"
						value="${user.display_name}" /></td>
			</tr>
			<tr>
				<td>age</td>
				<td><input type="text" name="age" value="${user.age}" /></td>
			</tr>
			<tr>
				<td>dender</td>
				<td><input type="text" name="gender" value="${user.gender}" /></td>
			</tr>
			<tr>
				<td>auth</td>
				<td><input type="text" name="auth" value="${user.auth}" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="CREATE" /></td>
			</tr>
		</table>
	</form>
</body>
</html>