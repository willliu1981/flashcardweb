<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLASH CARD</title>
</head>
<body>

	<h1>Welcome to FlashCard</h1>
	<h2>
		<a href="test/test?">test</a>
	</h2>
	<h2>
		<a href="test/test?username=mary&password=1234&auth=default">test2</a>
	</h2>

	<h2>
		<a href="test/test3?username=david&password=1234&auth=default">test3</a>
	</h2>

	<h2>
		<a href="page/vocabulary">vocabulary</a>
	</h2>
	<h2>
		<a href="page/card">card</a>
	</h2>
	<h2>
		<a href="page/exam">exam</a>
	</h2>
	<h2>
		<a href="login">login</a>
	</h2>
	<h2>
		<a href="user/test3">query user</a>
	</h2>



	<form action="test/test4" method="post">
		<table>
			<tr>
				<input type="text" value="david" name="username"></input>
			</tr>
			<tr>
				<input type="text" value="1234" name="password"></input>
			</tr>
			<tr>
				<input type="text" value="tk123456" name="token"></input>
			</tr>
			<tr>
				<input type="text" value="33" name="age"></input>
			</tr>
			<tr>
				<input type="text" value="common" name="auth"></input>
			</tr>
			<tr>
				<input type="submit" value="send">
			</tr>
		</table>
	</form>

</body>
</html>