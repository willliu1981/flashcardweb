<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>會員資料</legend>
		<table>
			<tr>
				<td>名稱</td>
				<td>${user.displayName }</td>
			</tr>
			<tr>
				<td>帳號</td>
				<td>${user.username }</td>
			</tr>
			<tr>
				<td>權限</td>
				<td>${user.authority }</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${data.email }</td>
			</tr>
		</table>
	</fieldset>
	<br />
	<c:if test="${token =='admin'}">
		<fieldset>
			<legend>管理會員資料 (${users.size() }) </legend>
			<table style="border: 3px #cccccc solid" cellpadding="10" border="1">
				<tr>
					<th>id</th>
					<th>username</th>
					<th>display name</th>
					<th>email</th>
					<th>authority</th>
				</tr>
				<c:forEach var="i" begin="0" end="${users.size() }">
					<tr>
						<td><c:out value="${users[i].u_id }" /></td>
						<td><c:out value="${users[i].username }" /></td>
						<td><c:out value="${users[i].displayName }" /></td>
						<td><c:out value="${userdatas[i].email }" /></td>
						<td><c:out value="${users[i].authority }" /></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</c:if>

</body>
</html>