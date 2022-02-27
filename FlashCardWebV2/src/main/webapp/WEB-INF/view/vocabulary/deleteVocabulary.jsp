<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flash card v2</title>
</head>
<body>
	<h1>Delete Vocabulary</h1>
	<form action="<%=request.getContextPath()%>/vocabulary/delete" method="post">
		<table>
			<tr>
				<td>vocabulary id</td>
				<td><input type="text" name="vid" value="${vid}"/></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>