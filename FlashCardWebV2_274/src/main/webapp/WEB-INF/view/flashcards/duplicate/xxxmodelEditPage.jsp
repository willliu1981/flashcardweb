<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <c:if test="${empty data.id}" var="toAdd" />

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="${toAdd?'新增':'編輯'} Flashcar" />
    </jsp:include>

    <div class="container">
        <form:form action="${pageContext.request.contextPath}/flashcard" modelAttribute="data"
            cssClass="form-horizontal">
            <fieldset>
                <legend>
                    <c:choose>
                        <c:when test="${toAdd }">新增 Flashcar</c:when>
                        <c:otherwise>編輯 Flashcar
                       <%--  <input type="hidden" name="id" value="${data.id}" /> --%>
                            <input type="hidden" name="_method" value="put" />
                        </c:otherwise>
                    </c:choose>
                </legend>
                <div class="form-group">
                    <label for="term" class="col-lg-2 control-label">Term</label>
                    <div class="col-lg-10">
                        <form:input path="term" id="term" cssClass="form-control" placeholder="ex: apple" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="definition" class="col-lg-2 control-label">Definition</label>
                    <div class="col-lg-10">
                        <form:input path="term" id="definition" cssClass="form-control" placeholder="ex: 蘋果" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default" style="color: black;">Cancel</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>

</body>
</html>