<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
    <!-- 導航欄 -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand ${param.active eq 'home'?'hrefDisabled':''}"
                    href="${pageContext.request.contextPath}/index.jsp">FlashCard</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li <c:if test="${param.active eq 'manage'}">class="active"</c:if>><a
                            <c:if test="${param.active eq 'manage'}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/flashcard/manager">字卡管理</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li <c:if test="${param.active eq 'manage-flashcard'}">class="active"</c:if>><a
                                    <c:if test="${param.active eq 'manage-flashcard'}">class="hrefDisabled"</c:if>
                                    href="${pageContext.request.contextPath}/flashcard/flashcardDetail">Flashcard</a></li>

                            <li <c:if test="${param.active eq 'manage-flashcardHolder'}">class="active"</c:if>><a
                                    <c:if test="${param.active eq 'manage-flashcardHolder'}">class="hrefDisabled"</c:if>
                                    href="${pageContext.request.contextPath}/flashcard/handledCardDetail">FlashcardHolder</a></li>
                        </ul></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" data-target="#myModal" data-toggle="modal">關於</a></li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>