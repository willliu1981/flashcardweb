<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
    <!-- path mapping  (亦用於 include page 的 active)-->
    <c:set var="home" value="index.jsp" />
    <c:set var="flashcardsManager" value="flashcards/fcsManager" />
    <c:set var="flashcardManager" value="flashcards/fcManager" />
    <c:set var="flahscardHolderManager" value="flashcards/fhManager" />
    <c:set var="holderDataManager" value="flashcards/hdManager" />

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
                    href="${pageContext.request.contextPath}/<c:out value="${home}"></c:out>">FlashCard</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li <c:if test="${param.active eq 'flashcardsManager'}">class="active"</c:if>><a
                            <c:if test="${param.active eq 'flashcardsManager'}">class="hrefDisabled"</c:if>
                            href="${pageContext.request.contextPath}/<c:out value="${flashcardsManager}"></c:out>">字卡管理</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li <c:if test="${param.active eq 'flashcardManager'}">class="active"</c:if>><a
                                    <c:if test="${param.active eq 'flashcardManager'}">class="hrefDisabled"</c:if>
                                    href="${pageContext.request.contextPath}/<c:out value="${flashcardManager}"></c:out>">Flashcard</a></li>

                            <li <c:if test="${param.active eq 'flahscardHolderManager'}">class="active"</c:if>><a
                                    <c:if test="${param.active eq 'flahscardHolderManager'}">class="hrefDisabled"</c:if>
                                    href="${pageContext.request.contextPath}/<c:out value="${flahscardHolderManager}"></c:out>">FlashcardHolder</a></li>

                            <li <c:if test="${param.active eq 'holderDataManager'}">class="active"</c:if>><a
                                    <c:if test="${param.active eq 'holderDataManager'}">class="hrefDisabled"</c:if>
                                    href="${pageContext.request.contextPath}/<c:out value="${holderDataManager}"></c:out>">HolderData</a></li>
                        </ul></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" data-target="#myModal" data-toggle="modal">關於</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- 模態框 -->
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">FlashCard</h4>
                </div>
                <div class="modal-body">
                    <p>編輯中&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <font color="black"> Close</font>
                    </button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</body>
</html>