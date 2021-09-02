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
				<td>${member.displayName }</td>
			</tr>
			<tr>
				<td>帳號</td>
				<td>${member.username }</td>
			</tr>
			<tr>
				<td>權限</td>
				<td>${member.authority }</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>