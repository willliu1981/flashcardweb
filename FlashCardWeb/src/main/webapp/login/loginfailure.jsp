<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>failure</title>
<c:url var="jqueryUrl" value="/js/jquery-3.6.0.min.js"/>
<c:url var="loginUrl" value="/login/login.jsp"/>
<c:url var="registerUrl" value="/login/register.jsp"/>
<c:url var="indexUrl" value="/index.jsp"/>
<script type="text/javascript" src="${jqueryUrl}"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#reback").click(function() {
			location.href = "${loginUrl}";
		});
		
		$("#register").click(function() {
			location.href = "${registerUrl}";
		});

		$("#home").click(function() {
			location.href = "${indexUrl}";
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>登入失敗</legend>
		<table>
			<tr>
				<td><button type="button" id="reback">返回</button></td>
				<td><label>返回登入頁面,重新登入</label></td>
			</tr>
			<tr>
				<td><button type="button" id="register">返回</button></td>
				<td><label>前往註冊頁面,進行註冊</label></td>
			</tr>
			<tr>
				<td><button type="button" id="home">首頁</button></td>
				<td><label>返回首頁</label></td>
			</tr>
		</table>
	</fieldset>
</body>
</html>