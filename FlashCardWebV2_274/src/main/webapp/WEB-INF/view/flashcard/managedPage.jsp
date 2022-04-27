<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/EvenTable.css">
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.0/css/bootstrap.min.css"> --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/css/bootstrap-theme.min.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron">
		<h1>FlashCard</h1>
		<p>This is a simple hero unit, a simple jumbotron-style component
			for calling extra attention to featured content or information.</p>

	</div>

	<div class="list-group">
		<a href="javascript:;"
			class="list-group-item disabled">FlashCard Manager</a>
		<a href="${pageContext.request.contextPath}/flashcard/flashcardDetail"
			class="list-group-item">FlashCard</a>
		<a href="${pageContext.request.contextPath}/flashcard/handledCardDetail" 
			class="list-group-item">HandledCard</a>
	</div>







</body>
</html>