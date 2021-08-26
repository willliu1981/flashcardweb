<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>failure</title>
<script type="text/javascript"
	src="/FlashCardWeb/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reback").click(function() {
			location.href = "/FlashCardWeb/login/register.jsp";
		});

		$("#home").click(function() {
			location.href = "/FlashCardWeb/index.jsp";
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