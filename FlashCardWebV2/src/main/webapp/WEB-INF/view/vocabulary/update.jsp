<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flash card v2</title>
</head>
<body>
	<h1>Update Vocabulary</h1>
	<form action="<%=request.getContextPath()%>/process/vocabulary/update"
		method="post">
		<table>
			<tr>
				<td>from vocabulary id</td>
				<td><input type="text" name="from-vid" value="${fromVid}" /></td>
			</tr>
			<tr>
				<td>to vocabulary id</td>
				<td><input type="text" name="to-vid" value="${toVid}" /></td>
			</tr>
			<tr>
				<td>vocabulary</td>
				<td><input type="text" name="vocabulary" value="${vocabulary}" /></td>
			</tr>
			<tr>
				<td>translation</td>
				<td><input type="text" name="translation"
						value="${translation}" /></td>
			</tr>
			<tr>
				<td>tag</td>
				<td><input type="text" name="tag" value="${tag}" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>