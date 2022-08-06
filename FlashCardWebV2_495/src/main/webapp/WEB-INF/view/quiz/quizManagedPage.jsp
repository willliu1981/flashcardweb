<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
<style type="text/css">
</style>

<!-- global variable -->
<script type="text/javascript">
  const flashcards = "flashcards";//base path
  const quiz = "quiz"; 
  const basePath = {
	context : "/FlashCardWebV2",
	version : "",
	path : function() {
	  return this.context + "/" + this.version;
	}
  };
</script>

<!-- import version and process other  element -->
<script type="text/javascript" src="../../js/version.js"></script>
<script type="text/javascript" src="../../js/nav.js"></script>

<!-- 
processVersion() => ajax => processNav() => other
-->
<script type="text/javascript">
  $(function() {
	processVersion();

  });
</script>
<!-- /import version and process nav element -->

<script type="text/javascript">
  $(document).ready(
	  function() {
		//submit
		$(".form-group .btn-start").click(
			function() {
			  var filter = $("#select-filter").val();
			  var mod = $("#select-mod").val();
			  var num = $("#inputNum").val();

			  $.ajax({
				type : "get",
				datatype : "json",
				url : basePath.path() + "/quiz/data/" + filter + "/" + mod
					+ "/" + num,
				success : function(resp) {
				  if (resp.data.length == 0) {
					alert("沒有資料");
				  } else {
					location.href = basePath.path() + "/quiz/" + filter + "/"
						+ mod + "/" + num;
				  }
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
        <jsp:param name="version" value="${initParam['version']}" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="字卡測驗管理" />
    </jsp:include>

    <!--  method="get" action="${pageContext.request.contextPath}/{path}" -->
    <div class="container">
        <form class="form-horizontal">
            <fieldset>
                <legend>Quiz</legend>
                <div class="form-group">
                    <label class="col-sm-2 control-label">測驗策略</label>
                    <div class="col-sm-10">
                        <div class="form-group">
                            <!-- <label for="select" class="col-sm-2 control-label"> </label> -->
                            <div class="col-sm-12">
                                <select class="form-control" id="select-filter">
                                    <option value="period" style="color: cyan;" selected>週期模式</option>
                                    <option value="common" style="color: cyan;">一般模式</option>
                                </select>
                            </div>

                            <div class="col-sm-12">
                                <p></p>
                            </div>

                            <!-- <label for="select" class="col-sm-2 control-label"> </label> -->
                            <div class="col-sm-12">
                                <select class="form-control" size="3" id="select-mod">
                                    <option value="random" selected>隨機</option>
                                    <option value="proficiency">熟練度</option>
                                    <option value="time">時間</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNum" class="col-lg-2 control-label">測驗數量</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="inputNum" value="20">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default" style="color: black;">Cancel</button>
                        <button type="button" class="btn btn-primary btn-start">Start</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>

</body>
</html>