<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>failure</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#member").click(function() {
			location.href = "${pageContext.request.contextPath}/account/member.do";
		});

		$("#home").click(function() {
			location.href = "${pageContext.request.contextPath}/index.jsp";
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>刪除會員失敗</legend>
		<table>
			<tr>
				<td><button type="button" id="member">返回</button></td>
				<td><label>返回會員頁面</label></td>
			</tr>
			<tr>
				<td><button type="button" id="home">首頁</button></td>
				<td><label>返回首頁</label></td>
			</tr>
		</table>
	</fieldset>
</body>
</html>