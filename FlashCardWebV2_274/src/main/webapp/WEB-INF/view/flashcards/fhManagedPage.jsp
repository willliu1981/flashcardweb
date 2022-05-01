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
        <jsp:param name="active" value="flahscardHolderManager" />
    </jsp:include>

     <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="管理 FlashcardHolder" />
    </jsp:include>



    <div class="container" style="background-color: orange;">
        <ul class="pagination">
            <li class="disabled"><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>
    </div>

    <table class="evenTable">
        <tr>
            <td><font size="6" color="blue">FlashcardHolder Manager</font>
        </tr>
        <c:forEach var="v" items="${vocabularys}">
            <tr>
                <td><c:out value="${v.vocabulary}"></c:out>
                <td><c:out value="${v.translation}"></c:out>
            </tr>
        </c:forEach>


    </table>





</body>
</html>