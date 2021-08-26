<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<fieldset>
		<legend>註冊帳號</legend>
		<form action="/FlashCardWeb/RegisterServlet" method="post">
			<table style="text-align:center">
				<tr>
					<td>帳號</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td>名稱</td>
					<td><input type="text" name="displayname"></td>
				</tr>
				<tr>
					<td>電子信箱</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="送出"></td>
				</tr>

			</table>

		</form>
	</fieldset>
</body>
</html>