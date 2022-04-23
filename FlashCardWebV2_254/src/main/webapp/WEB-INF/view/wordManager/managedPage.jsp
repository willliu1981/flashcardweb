<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/EvenTable.css">


</head>
<body>

	<h1>Word Manager</h1>
	<table class="evenTable">
		<tr>
			<td><font size="6" color="blue">Word Manager</font>
		</tr>
		<tr>
			<td
				onclick="window.location.href='${pageContext.request.contextPath}/word/word';"><font
				size="6" color="blue">Word</font>
		</tr>
		<tr>
			<td
				onclick="window.location.href='${pageContext.request.contextPath}/word/card';"><font
				size="6" color="blue">Card</font>
		</tr>

	</table>





</body>
</html>