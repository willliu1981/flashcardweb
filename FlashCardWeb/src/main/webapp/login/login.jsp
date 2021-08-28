<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#forget").click(function() {
			location.href = ".jsp";
		});

		$("#register").click(function() {
			location.href = "${pageContext.request.contextPath}/login/register.jsp";
		});

		$("#home").click(function() {
			location.href = "${pageContext.request.contextPath}/index.jsp";
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>登入</legend>
		<form action="/FlashCardWeb/LoginServlet" method="post">
			<table style="text-align:center">
				<tr>
					<td>帳號</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="送出"></td>
				</tr>

			</table>

		</form>


	</fieldset>
	<fieldset>
		<table>
			<tr>
				<td><button type="button" id="forget">忘記密碼</button></td>
				<td><button type="button" id="register">註冊</button></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<table>
			<tr>
				<td><button type="button" id="home">回首頁</button></td>
			</tr>
		</table>
	</fieldset>
</body>
</html>