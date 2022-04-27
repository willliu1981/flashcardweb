<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/EvenTable.css">

</head>
<body>

	<h1>Card Manager</h1>
	<table class="evenTable">
		<tr>
			<td><font size="6" color="blue">Card Manager</font>
		</tr>
		<c:forEach var="v" items="${vocabularys}">
			<tr>
				<td><c:out value="${v.vocabulary}"></c:out>
			</tr>
			<tr>
				<td><c:out value="${v.translation}"></c:out>
			</tr>
		</c:forEach>


	</table>





</body>
</html>