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
		<a href="test/test?username=david2">test</a>
	</h2>
	<h2>
		<a href="test/test2?username=mary">test2</a>
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
		<a href="user/toQuery">query user</a>
	</h2>

	<form action="test/test" mthod="post">
		<table>
			<tr>
				<input type="text" value="david" name="username"></input>
			</tr>
			<tr>
				<input type="submit" value="send">
			</tr>
		</table>
	</form>

</body>
</html>