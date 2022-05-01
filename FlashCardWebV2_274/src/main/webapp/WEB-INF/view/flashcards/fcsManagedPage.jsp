<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <c:set var="flashcardManager" value="flashcards/fcManager" />
    <c:set var="flahscardHolderManager" value="flashcards/fhManager" />

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="flashcardsManager" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="管理 Flashcard & FlashcardHolder" />
    </jsp:include>

    <!-- 清單 -->
    <div class="container">
        <div class="list-group">
            <a href="javascript:;" class="list-group-item disabled">字卡編輯</a>
            <a href="${pageContext.request.contextPath}/<c:out value="${flashcardManager}"></c:out>"
                class="list-group-item">FlashCard</a>
            <a href="${pageContext.request.contextPath}/<c:out value="${flahscardHolderManager}"></c:out>"
                class="list-group-item">FlashcardHolder</a>
        </div>
    </div>

   
</body>
</html>