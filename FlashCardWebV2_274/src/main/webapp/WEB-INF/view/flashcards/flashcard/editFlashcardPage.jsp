<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <!-- header include nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="flashcard-add" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="編輯 Flashcard" />
    </jsp:include>

    <div class="container">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/flashcard">
            <input type="hidden" name="id" value="${flashcard.id}" />
            <input type="hidden" name="_method" value="put" />
            <fieldset>
                <legend>編輯 Flashcard</legend>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Term</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="term" placeholder="Ex: apple"
                            value="${flashcard.term}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Definition</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="definition" placeholder="Ex: 蘋果"
                            value="${flashcard.definition}">
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