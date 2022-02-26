<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Vocabulary</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/vocabulary/add" method="post">
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
</body>
</html>