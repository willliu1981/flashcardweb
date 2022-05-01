<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="home" />
    </jsp:include>




    <div class="container" id="x1">
        <h1>歡迎使用 FlashCard</h1>
    </div>

    <jsp:include page="/WEB-INF/view/public/test.jsp" flush="true">
        <jsp:param name="active" value="homePage" />
    </jsp:include>




    <div class="container">
        <h4>Copyright &copy; 2021-2022 FlashCard. All rights reserved.</h4>
    </div>

    <div class="container">
        <h4>
            <c:forEach items="${fcs}" var="f">
       f= ${f.getDefinition()}
        <br />
            </c:forEach>

        </h4>

    </div>



</body>
</html>