<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/EvenTable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.0/css/bootstrap-theme.min.css">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>



	<div class="container">
		<div class="row">
			<div class="col-md-1">1-1</div>
			<div class="col-md-1">1-2</div>
			<div class="col-md-1">1-3</div>
			<div class="col-md-1">1-4</div>
			<div class="col-md-1">1-5</div>
			<div class="col-md-1">1-6</div>

		</div>
		<div class="row">
			<div class="col-md-3">2-1</div>
			<div class="col-md-3">2-2</div>

		</div>

		<div class="row">
			<div class="col-md-1">3-1</div>
			<div class="col-md-2">3-2</div>
			<div class="col-md-3">3-3</div>

		</div>

	</div>



</body>
</html>