<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test</h1>

	<a href="spring/delete">delete </a>
	<br />add
	<br />
	<form action="spring/add" method="post">
		<table>
			<tr>
				<td>vocabulary</td>
				<td><input type="text" name="vocabulary" /></td>
			</tr>
			<tr>
				<td>translation</td>
				<td><input type="text" name="translation" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
	<br />delete
	<br />
	<form action="spring/delete" method="post">
		<table>
			<tr>
				<td>vocabulary id</td>
				<td><input type="text" name="vid" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>