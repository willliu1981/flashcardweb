<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <c:set var="pathFlashcard" value="flashcard" />
    <!-- web base path -->
    <c:set var="flashcardManager" value="flashcards/fcManager" />

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="flashcardManager" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="管理 Flashcard" />
    </jsp:include>

    <!-- list -->
    <div class="container">
        <ul class="list-group myBadgeCursor">
            <li class="list-group-item"><span class="badge"
                    onclick="location.href='${pageContext.request.contextPath}/<c:out value="${pathFlashcard}"></c:out>'">
                    <font size="5">ADD</font>
                </span>
                <h3>Flashcard</h3></li>
            <c:forEach var="fc" items="${flashcards}">
                <li class="list-group-item"><a href="#" class="list-group-item">
                        <span class="badge"
                            onclick="location.href='${pageContext.request.contextPath}/<c:out value="${pathFlashcard}"></c:out>/${fc.id}'">
                            <font size="4">EDIT</font>
                        </span>
                        <h4 style="font-size: 36px;" class="list-group-item-heading">
                            <c:out value="${fc.term}"></c:out>
                        </h4>
                        <p style="font-size: 22px;" class="list-group-item-text">
                            <c:out value="${fc.definition}"></c:out>
                        </p>
                    </a></li>
            </c:forEach>
        </ul>
    </div>

    <!-- 分頁 -->
    <div class="container">
        <ul class="pager ">
            <li>
                <ul class="pagination">
                    <li></li>
                    <!-- 首頁 -->
                    <li <c:if test="${pageInfo.pageNum==1}">class="disabled"</c:if>><a
                            <c:if test="${pageInfo.pageNum==1}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${flashcardManager}"></c:out>/1">&laquo;</a></li>

                    <!-- 上一頁 -->
                    <li <c:if test="${!pageInfo.isHasPreviousPage()}">class="disabled"</c:if>><a
                            <c:if test="${!pageInfo.isHasPreviousPage()}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${flashcardManager}"></c:out>/<c:out value="${pageInfo.pageNum-1}" />">Previous</a></li>
                    <!-- 中間頁數 -->
                    <c:forEach var="i" begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}">
                        <li <c:if test="${pageInfo.pageNum==i}">class="active"</c:if>><a
                                <c:if test="${pageInfo.pageNum==i}">class="hrefDisabled"</c:if>
                                href="${pageContext.request.contextPath}/<c:out value="${flashcardManager}"></c:out>/<c:out value="${i}" />">
                                <c:out value="${i}" />
                            </a></li>
                    </c:forEach>

                    <!-- 下一頁 -->
                    <li <c:if test="${!pageInfo.isHasNextPage()}">class="disabled"</c:if>><a
                            <c:if test="${!pageInfo.isHasNextPage()}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${flashcardManager}"></c:out>/<c:out value="${pageInfo.pageNum+1}" />">Next</a></li>

                    <!-- 最末頁 -->
                    <li <c:if test="${pageInfo.isIsLastPage()}">class="disabled"</c:if>><a
                            <c:if test="${pageInfo.isIsLastPage()}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${flashcardManager}"></c:out>/<c:out value="${pageInfo.pages}" />">&raquo;</a></li>
                    <li></li>
                </ul>
            </li>
        </ul>
    </div>


</body>
</html>