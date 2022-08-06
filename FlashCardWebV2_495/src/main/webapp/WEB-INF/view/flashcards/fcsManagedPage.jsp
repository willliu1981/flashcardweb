<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />

</head>
<body>
    <c:set var="pathFlashcards" value="flashcards" />

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="flashcardsManager" />
        <jsp:param name="version" value="${initParam['version']}" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="管理 Flashcard 、 FlashcardHolder 、 HolderData" />
    </jsp:include>

    <!-- 清單 -->
    <div class="container">
        <ul class="list-group">
            <!-- <a href="javascript:;" class="list-group-item disabled "> 字卡編輯 </a> -->
            <li class="list-group-item"><a class="list-group-item"
                    href="${pageContext.request.contextPath}/${initParam['version']}/<c:out value="${pathFlashcards}/fcManager"></c:out>">
                    <p class="list-group-item-heading h4">FlashCard</p>
                </a></li>
            <li class="list-group-item"><a class="list-group-item"
                    href="${pageContext.request.contextPath}/${initParam['version']}/<c:out value="${pathFlashcards}/fhManager"></c:out>">
                    <p class="list-group-item-heading h4">FlashcardHolder</p>
                </a></li>
            <li class="list-group-item"><a class="list-group-item"
                    href="${pageContext.request.contextPath}/${initParam['version']}/<c:out value="${pathFlashcards}/hdManager"></c:out>">
                    <p class="list-group-item-heading h4">HolderData</p>
                </a></li>
        </ul>
    </div>

</body>
</html>