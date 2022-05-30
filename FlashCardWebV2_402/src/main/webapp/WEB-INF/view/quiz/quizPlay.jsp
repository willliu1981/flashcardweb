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

<!-- global variable -->
<script type="text/javascript">
  var pause = 0;//0='cycle' , 1='pause'
  var carousel;//'.carousel'
  var ids;//ids array
  var itemNums;//item count
</script>

<!-- process quiz finish  -->
<script type="text/javascript">
  const contextPath = "/FlashCardWebV2";

  $(document).ready(function() {
	$(".item").first().addClass("active");

	ids = $(".control-button .finish-slide").attr("data-ids");

	$(".control-button .finish-slide").click(function() {
	  $.ajax({
		type : "post",
		data : {
		  ids : ids
		},
		dataType : "json",
		url : contextPath + "/quiz",
		success : function(data) {
		  console.log("data=" + data.code);
		  window.location.href = contextPath + "/quiz/quizManager";//quiz完成時, 導向目的地
		},
		error : function(data) {
		  console.log("error=" + data);
		}
	  });
	});

  });
</script>

<!-- control button -->
<script type="text/javascript">
  $(function() {
	carousel = $('.carousel');
	itemNums = carousel.attr('data-itemNums');

	$('.control-button .pause-slide').click(function() {
	  carousel.carousel('pause');

	  $('.control-pauseMsg .pauseMsg').text('pause');
	  $('.control-pauseMsg .pauseMsg').fadeIn(200);
	  $('.control-pauseMsg .pauseMsg').fadeOut(500);

	});

	$('.control-button .start-slide').click(function() {
	  carousel.carousel('cycle');
	  
	  $('.control-pauseMsg .pauseMsg').text('start');
	  $('.control-pauseMsg .pauseMsg').fadeIn(200);
	  $('.control-pauseMsg .pauseMsg').fadeOut(500);
	  
	});

	$('.control-button .prev-slide').click(function() {
	  carousel.carousel('prev');
	});

	$('.control-button .next-slide').click(function() {
	  carousel.carousel('next');
	});

	$('.control-button .restart-slide').click(function() {
	  carousel.carousel(0);
	});

	// .active and last item
	var carouselItems = carousel.find('.item');
	$('.control-button .finish-slide').fadeOut(100);
	carousel.on('slid.bs.carousel', function(e) {
	  let currentIdx = carouselItems.siblings('.active').index();
	  if (currentIdx == itemNums - 1) {
		$('.control-button .finish-slide').fadeIn("slow");
	  }
	});
  });

  $(document).bind('keyup', function(e) {
	if (e.keyCode == 37) {
	  $('.control-button .prev-slide').trigger('click');

	} else if (e.keyCode == 39) {
	  $('.control-button .next-slide').trigger('click');

	  //'r'
	} else if (e.keyCode == 82) {
	  $('.control-button .restart-slide').trigger('click');

	} else if (e.keyCode == 32) {
	  pause = 1 - pause;

	  if (pause == 0) {
		$('.control-button .start-slide').trigger('click');

	  } else {
		$('.control-button .pause-slide').trigger('click');

	  }
	}

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
            data-pause="hover" data-wrap="false" data-keyboard="true" data-itemNums="${datas.size() }">

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
    <!-- //輪播 -->

    <!-- control button -->
    <div class="container " style="text-align: center;">
        <div class="container control-pauseMsg">
            <span class="pauseMsg h1"></span>
            <p></p>
        </div>

        <div class="container control-button">
            <input type="button" class="btn start-slide" value="Start">
            <input type="button" class="btn pause-slide" value="Pause">
            <input type="button" class="btn prev-slide" value="Previous">
            <input type="button" class="btn next-slide" value="Next">
            <input type="button" class="btn restart-slide" value="Restart">
            <input type="button" class="btn finish-slide" value="Finish" data-ids="${ids}" style="color:rgb(255,140,0);">
        </div>
    </div>

    <!-- footer -->
    <div class="container container-footer">
        <h4>Copyright &copy; 2021-2022 FlashCard. All rights reserved.</h4>
    </div>
</body>
</html>