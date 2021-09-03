<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>會員資料</legend>
		<table>
			<tr>
				<td>名稱</td>
				<td>${user.displayName }</td>
			</tr>
			<tr>
				<td>帳號</td>
				<td>${user.username }</td>
			</tr>
			<tr>
				<td>權限</td>
				<td>${user.authority }</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${data.email }</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>