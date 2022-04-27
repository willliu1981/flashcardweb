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
	<h1>LOGIN</h1>
	<hr>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table class="evenTable">
			<tr>
				<td><font size="6" color="blue">LOGIN</font></td>
				<td style="text-align: right"><a
					href="${pageContext.request.contextPath}/register"><font
						size="5" color="BlueViolet">register</font> </a></td>
			</tr>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" value="${user.username}" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="LOGIN" /></td>
			</tr>
		</table>
	</form>
</body>
</html>