<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
    <c:set var="pathForPager" value="${facade.pathForPager}"></c:set>

    <!-- 分頁 -->
    <div class="container">
        <ul class="pager ">
            <li>
                <ul class="pagination">
                    <li></li>
                    <!-- 首頁 -->
                    <li <c:if test="${pageInfo.pageNum==1}">class="disabled"</c:if>><a
                            <c:if test="${pageInfo.pageNum==1}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${pathForPager}"></c:out>/1">&laquo;</a></li>

                    <!-- 上一頁 -->
                    <li <c:if test="${!pageInfo.isHasPreviousPage()}">class="disabled"</c:if>><a
                            <c:if test="${!pageInfo.isHasPreviousPage()}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${pathForPager}"></c:out>/<c:out value="${pageInfo.pageNum-1}" />">Previous</a></li>
                    <!-- 中間頁數 -->
                    <c:forEach var="i" begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}">
                        <li <c:if test="${pageInfo.pageNum==i}">class="active"</c:if>><a
                                <c:if test="${pageInfo.pageNum==i}">class="hrefDisabled"</c:if>
                                href="${pageContext.request.contextPath}/<c:out value="${pathForPager}"></c:out>/<c:out value="${i}" />">
                                <c:out value="${i}" />
                            </a></li>
                    </c:forEach>

                    <!-- 下一頁 -->
                    <li <c:if test="${!pageInfo.isHasNextPage()}">class="disabled"</c:if>><a
                            <c:if test="${!pageInfo.isHasNextPage()}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${pathForPager}"></c:out>/<c:out value="${pageInfo.pageNum+1}" />">Next</a></li>

                    <!-- 最末頁 -->
                    <li <c:if test="${pageInfo.isIsLastPage()}">class="disabled"</c:if>><a
                            <c:if test="${pageInfo.isIsLastPage()}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${pathForPager}"></c:out>/<c:out value="${pageInfo.pages}" />">&raquo;</a></li>
                    <li></li>
                </ul>
            </li>
        </ul>
    </div>
</body>
</html>