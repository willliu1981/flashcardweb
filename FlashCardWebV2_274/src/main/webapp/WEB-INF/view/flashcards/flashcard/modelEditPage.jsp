<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <jsp:param name="title" value="新增 Flashcard" />
    </jsp:include>

    <div class="container">
        <form:form action="${pageContext.request.contextPath}/flashcard" modelAttribute="data">
            <fieldset>
                <legend>Flashcard</legend>
                <div class="form-group">
                    <label for="term" class="col-lg-2 control-label">Term</label>
                    <div class="col-lg-10">
                        <form:input path="term" id="term" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="definition" class="col-lg-2 control-label">Definition</label>
                    <div class="col-lg-10">
                        <form:input path="term" id="definition" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default">Cancel</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>

</body>
</html>