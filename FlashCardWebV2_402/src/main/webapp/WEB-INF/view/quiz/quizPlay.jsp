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
	font-size: 100px;
	height: 85%;
	left: 0%;
	color: rgb(225, 225, 225);
}
</style>

<script type="text/javascript">
  const contextPath = "/FlashCardWebV2";

  $(document).ready(function() {
	$(".item").first().addClass("active");

	var ids = $(".btn-quiz-finish").attr("data-ids");

	$(".btn-quiz-finish").click(function() {
	  $.ajax({
		type : "post",
		data : {
		  ids : ids
		},
		dataType : "json",
		url : contextPath + "/quiz",
		success : function(data) {
		  console.log("data=" + data.code);
		  window.location.href = contextPath + "/quiz";
		},
		error : function(data) {
		  console.log("error=" +data);
		}
	  });
	});

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
                        <img src="${pageContext.request.contextPath}/picture/blackboard_1.png" />
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
                <span class="glyphicon " style="font-size: 75px;" aria-hidden="true"></span>
                <!-- glyphicon-triangle-left glyphicon-chevron-left -->
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon " style="font-size: 75px;" aria-hidden="true"></span>
                <!-- glyphicon-triangle-right glyphicon-chevron-right -->
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div class="container" style="text-align: center;">
        <input type="button" class="btn start-slide" value="Start">
        <input type="button" class="btn pause-slide" value="Pause">
        <input type="button" class="btn prev-slide" value="Previous Slide">
        <input type="button" class="btn next-slide" value="Next Slide">
        <input type="button" class="btn slide-one" value="Slide 1">
        <input type="button" class="btn slide-two" value="Slide 2">
        <input type="button" class="btn slide-three" value="Slide 3">
    </div>

    <div class="container">
        <button class="btn btn-default btn-quiz-finish" data-ids="${ids}">Finish</button>
    </div>
</body>
</html>