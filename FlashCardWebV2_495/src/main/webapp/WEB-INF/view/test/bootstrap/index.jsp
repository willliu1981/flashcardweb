<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>FLASH CARD</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="styleSheet" type="text/css" href="${pageContext.request.contextPath}/css/EvenTable.css">
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.0/css/bootstrap.min.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/css/bootstrap-theme.min.css">

<style type="text/css">
#carousel-example-generic .carousel-inner>.item>.img {
	display: block;
	width: 100%;
	height: 750px;
}

.my-carousel {
	height: 750px;
	overflow: hidden;
}
</style>

</head>
<body>

    <div class="container-fluid">
        <nav class="navbar navbar-default">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">FlashCard</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <!--   <li class="active"><a href="#"><span class="sr-only">(current)</span>
                        </a></li> -->
                        <li><a href="#">Flashcard manager</a></li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                            role="button" aria-expanded="false"><span class="caret"></span>
                        </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Flashcard</a></li>
                                <li><a href="#">HandledCard</a></li>
                                <!-- <li class="divider"></li>
                                <li><a href="#">Separated link</a></li> -->
                            </ul></li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Link</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div id="carousel-example-generic" class="carousel slide my-carousel" data-ride="carousel" data-interval="3000"
        data-pause="null" data-wrap="true">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="${pageContext.request.contextPath}/picture/tile1.jpg" />
                <div class="carousel-caption">...</div>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/picture/tile2.jpg" />
                <div class="carousel-caption">...</div>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/picture/tile3.jpg" />
                <div class="carousel-caption">...</div>
            </div>


        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span
                class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">Previous</span>
        </a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span
                class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">Next</span>
        </a>
    </div>




    <h1>Welcome to FlashCard</h1>
    <h2>
        <a href="test/test1">test</a>
    </h2>

    <h2>
        <a href="flashcard/manager">Flashcard Manager</a>
    </h2>




</body>
</html>