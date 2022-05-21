<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.myCaption {
	font-size: 133px;
	height: 75%;;
	color: rgb(10,100,10);
}
</style>

<script type="text/javascript">
  $(document).ready(function() {
	$(".item").first().addClass("active");
  });
</script>
</head>
<body>

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="quizManager" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="字卡測驗" />
    </jsp:include>

    <!-- 輪播 -->
    <div class="container">
        <div id="carousel-example-generic" class="carousel slide my-carousel " data-ride="carousel" data-interval="3000"
            data-pause="hover" data-wrap="false" data-keyboard="true">

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <c:forEach var="data" items="${datas}">
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/picture/card_1.png" />
                        <div class="carousel-caption myCaption">
                            <div>
                                <span>
                                    <c:out value="${data.term }"></c:out>
                                </span>
                            </div>
                            <div>
                                <span>
                                    <c:out value="${data.definition }"></c:out>
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- Controls -->
            <a class="left carousel-control carousel-control" href="#carousel-example-generic" role="button"
                data-slide="prev">
                <span class="glyphicon glyphicon-triangle-left glyphicon-chevron-left" style="font-size: 75px;"
                    aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-triangle-right glyphicon-chevron-right" style="font-size: 75px;"
                    aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div class="container" style="text-align:center;">
        <input type="button" class="btn start-slide" value="Start">
        <input type="button" class="btn pause-slide" value="Pause">
        <input type="button" class="btn prev-slide" value="Previous Slide">
        <input type="button" class="btn next-slide" value="Next Slide">
        <input type="button" class="btn slide-one" value="Slide 1">
        <input type="button" class="btn slide-two" value="Slide 2">
        <input type="button" class="btn slide-three" value="Slide 3">
    </div>
</body>
</html>