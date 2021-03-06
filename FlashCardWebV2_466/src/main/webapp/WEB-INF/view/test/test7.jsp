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
	color: green;
}
</style>

<script type="text/javascript">
  $(document).ready(function() {
	$(".item").first().addClass("active");
  });
</script>
</head>
<body>


    <!-- 輪播 -->
    <div class="container">
        <div id="carousel-example-generic" class="carousel slide my-carousel " data-ride="carousel" data-interval="3000"
            data-pause="hover" data-wrap="false" data-keyboard="true">
            <!-- Indicators -->
            <!--         <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol> -->


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
            <a class="left carousel-control carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
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
</body>
</html>