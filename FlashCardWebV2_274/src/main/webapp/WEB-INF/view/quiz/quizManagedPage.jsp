<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
<style type="text/css">
</style>

<script type="text/javascript">
  $(document).ready(function() {
	//submit
	$(".form-group .btn-primary").click(function() {
	  var contextPath = $(this).attr("data-myContextPath");
	  var mod = $("input:radio:checked").val();
	  var num = $("#inputNum").val();

	  location.href = contextPath + "/quiz/" + mod + "/" + num;
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
        <jsp:param name="title" value="字卡測驗管理" />
    </jsp:include>

    <!--  method="get" action="${pageContext.request.contextPath}/{path}" -->
    <div class="container">
        <form class="form-horizontal">
            <fieldset>
                <legend>Quiz</legend>
                <div class="form-group">
                    <label class="col-lg-2 control-label">測驗策略</label>
                    <div class="col-lg-10">
                        <div class="radio">
                            <label> <input type="radio" name="radioMod" id="radioMod1" value="period" checked>
                                週期模式
                            </label>
                        </div>
                        <div class="radio">
                            <label> <input type="radio" name="radioMod" id="radioMod2" value="proficiency">
                                熟練度模式
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNum" class="col-lg-2 control-label">待測數量</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="inputNum" value="20">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default" style="color: black;">Cancel</button>
                        <button type="button" class="btn btn-primary"
                            data-myContextPath="${pageContext.request.contextPath }">Start</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>

</body>
</html>