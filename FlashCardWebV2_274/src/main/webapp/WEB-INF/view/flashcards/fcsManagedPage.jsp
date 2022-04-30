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

    <!-- header include nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="manage" />
    </jsp:include>

    <!-- 巨屏 -->
    <div class="jumbotron">
        <div class="container">
            <h1>FlashCard</h1>
            <p>Flashcard 管理</p>
        </div>
    </div>

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
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</body>
</html>