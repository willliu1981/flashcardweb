<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flash card v2</title>
</head>
<body>
	<h1>Query Vocabulary</h1>
	<form action="<%=request.getContextPath()%>/vocabulary/query" method="post">
		<table>
			<tr>
				<td>vocabulary id</td>
				<td><input type="text" name="vid" value="${vid}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>