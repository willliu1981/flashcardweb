<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container" style="background-color: cyan;">
		<div></div>

	</div>



	<div class="container" style="background-color: yellow;">
		<div class="jumbotron">
			<div class="container">
				<h1>Hello, world!</h1>
			</div>

		</div>

	</div>



	<div class="container" style="background-color: cyan;">
		<div class="row">
			<div class="col-lg-3 col-md-4 col-sm-6">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/picture/wagasa.png"
					alt="xxx">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/picture/wagasa.png"
					alt="xxx">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/picture/wagasa.png"
					alt="xxx">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/picture/wagasa.png"
					alt="xxx">
				</a>
			</div>

		</div>
	</div>
	</div>


	<div class="container" style="background-color: orange;">
		<div class="progress progress-striped active">
			<div class="progress-bar" style="width: 45%"></div>
		</div>

	</div>


	<div class="container" style="background-color: cyan;">
		<ul class="breadcrumb">
			<li class="active">Home</li>
		</ul>

		<ul class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li class="active">Library</li>
		</ul>

		<ul class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">Library</a></li>
			<li class="active">Data</li>
		</ul>

	</div>



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

	<div class="container" style="background-color: cyan;">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span> </a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>

	<div class="container" style="background-color: cyan;"></div>





</body>
</html>