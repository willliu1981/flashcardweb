<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="新增 Holder Data" />
    </jsp:include>

    <div class="container">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/holderData">
            <fieldset>
                <legend>新增 Holder Data</legend>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Link Flashcard Holder ID</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="fhId" placeholder="Ex: 123">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default">Cancel</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>


</body>
</html>