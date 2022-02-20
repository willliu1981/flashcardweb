<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test card</h1>


	<br />add
	<br />
	<form action="word/card/add" method="post">
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>vid</td>
				<td><input type="text" name="vid" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
	<br />delete
	<br />
	<form action="word/card/delete" method="post">
		<table>
			<tr>
				<td>card id</td>
				<td><input type="text" name="cid" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>