<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>failure</title>
<%
request.setAttribute("root", "http://" + request.getHeader("host") + request.getContextPath());
%>

<script type="text/javascript" src="${root}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reback").click(function() {
			location.href = "${root}/login/register.jsp";
		});

		$("#home").click(function() {
			location.href = "${root}/index.jsp";
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>註冊失敗</legend>
		<table>
			<tr>
				<td><button type="button" id="reback">返回</button></td>
				<td><label>返回註冊頁面,重新註冊</label></td>
			</tr>
			<tr>
				<td><button type="button" id="home">首頁</button></td>
				<td><label>返回首頁</label></td>
			</tr>
		</table>
	</fieldset>
</body>
</html>