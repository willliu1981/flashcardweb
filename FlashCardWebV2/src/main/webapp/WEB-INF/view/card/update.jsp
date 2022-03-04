<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flash card v2</title>
</head>
<body>
	<h1>Update Card</h1>
	<form action="<%=request.getContextPath()%>/process/card/update"
		method="post">
		<table>
			<tr>
				<td>card id</td>
				<td><input type="text" name="cid" value="${cid}" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${name}" /></td>
			</tr>
			<tr>
				<td>user id</td>
				<td><input type="text" name="uid" value="${uid}" /></td>
			</tr>
			<tr>
				<td>vocabulary id</td>
				<td><input type="text" name="vid" value="${vid}" /></td>
			</tr>
			<tr>
				<td>last time</td>
				<td><input type="text" name="last_time" value="${last_time}" /></td>
			</tr>
			<tr>
				<td>usage count</td>
				<td><input type="text" name="usage_count"
						value="${usage_count}" /></td>
			</tr>
			<tr>
				<td>tag</td>
				<td><input type="text" name="tag" value="${tag}" /></td>
			</tr>
			<tr>
				<td>exam count</td>
				<td><input type="text" name="exam_count" value="${exam_count}" /></td>
			</tr>
			<tr>
				<td>pass count</td>
				<td><input type="text" name="pass_count" value="${pass_count}" /></td>
			</tr>
			<tr>
				<td>step</td>
				<td><input type="text" name="step" value="${step}" /></td>
			</tr>
			<tr>
				<td>step time</td>
				<td><input type="text" name="step_time" value="${step_time}" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
						value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>