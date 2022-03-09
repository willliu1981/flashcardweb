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
	<form action="${pageContext.request.contextPath}/page/login"
		method="post">
		<table class="evenTable">
			<tr>
				<td colspan="2">LOGIN</td>
			</tr>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" value="${username}" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="${password}" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>