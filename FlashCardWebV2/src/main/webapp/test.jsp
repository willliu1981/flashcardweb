<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test vocabulary</h1>
	<br />test
	<br />
	<form action="word/vocabulary/test" method="post">
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

	<br />add
	<br />
	<form action="word/vocabulary/add" method="post">
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
	<form action="word/vocabulary/delete" method="post">
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
	<br />update
	<br />
	<form action="word/vocabulary/update" method="post">
		<table>
			<tr>
				<td>from vocabulary id</td>
				<td><input type="text" name="from-vid" /></td>
			</tr>
			<tr>
				<td>to vocabulary id</td>
				<td><input type="text" name="to-vid" /></td>
			</tr>
			<tr>
				<td>vocabulary</td>
				<td><input type="text" name="vocabulary" /></td>
			</tr>
			<tr>
				<td>translation</td>
				<td><input type="text" name="translation" /></td>
			</tr>
			<tr>
				<td>tag</td>
				<td><input type="text" name="tag" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>