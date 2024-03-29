<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="idv.fc.controller.FlashcardsController"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />

<style type="text/css">
#carousel-example-generic .carousel-inner>.item>img {
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
    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="home" />
        <jsp:param name="version" value="${initParam['version']}" />
    </jsp:include>



    <!-- 輪播 -->
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
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>


    <div class="container" id="x1">
        <h1>歡迎使用 FlashCard</h1>
    </div>

    <div class="container">
        <a href="${pageContext.request.contextPath}/test/test1">
            <font size="5">test1</font>
        </a>
    </div>


    <div class="container container-footer">
        <h4>Copyright &copy; 2021-2022 FlashCard. All rights reserved.</h4>
    </div>

</body>
</html>