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

	<h1>Vocabulary Manager</h1>

	<div class="container" style="background-color: orange;">
		<ul class="pagination">
			<li class="disabled"><a href="#">&laquo;</a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>

	<table class="evenTable">
		<tr>
			<td><font size="6" color="blue">Card Manager</font>
		</tr>
		<c:forEach var="v" items="${vocabularys}">
			<tr>
				<td><c:out value="${v.vocabulary}"></c:out>
				<td><c:out value="${v.translation}"></c:out>
			</tr>
		</c:forEach>


	</table>





</body>
</html>