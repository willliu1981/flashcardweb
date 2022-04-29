<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css" href="${pageContext.request.contextPath}/css/EvenTable.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/css/bootstrap-theme.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.myBadgeCursor>li>.badge {
	cursor: pointer;
}
</style>

<!-- 使用 a href 失效 -->
<script type="text/javascript">
  $(function() {
	$('a.hrefDisabled').on("click", function(e) {
	  e.preventDefault();
	});
  });
</script>
</head>
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
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">FlashCard</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/flashcard/manager">字卡管理</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li class="active"><a class="hrefDisabled"
                                    href="${pageContext.request.contextPath}/flashcard/flashcardDetail">Flashcard</a></li>
                            <li><a href="${pageContext.request.contextPath}/flashcard/handledCardDetail">FlashcardHolder</a></li>
                        </ul></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" data-target="#myModal" data-toggle="modal">關於</a></li>
                </ul>
            </div>
        </div>

    </nav>

    <!-- 巨屏 -->
    <div class="jumbotron">
      <div class="container">
            <h1>FlashCard</h1>
            <p>Flashcard 編輯</p>
        </div>
    </div>

    <!-- list -->
    <div class="container">
        <ul class="list-group myBadgeCursor">
            <li class="list-group-item"><span class="badge"
                    onclick="location.href='${pageContext.request.contextPath}/flashcard'">ADD</span>
                <h3>Flashcard</h3></li>
            <c:forEach var="fc" items="${flashcards}">
                <li class="list-group-item"><a href="#" class="list-group-item">
                        <span class="badge" onclick="location.href='${pageContext.request.contextPath}/index.jsp'">EDIT</span>
                        <h4 class="list-group-item-heading">
                            <c:out value="${fc.term}"></c:out>
                        </h4>
                        <p class="list-group-item-text">
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
                            href="${pageContext.request.contextPath}/flashcard/flashcardDetail/1">&laquo;</a></li>

                    <!-- 上一頁 -->
                    <li <c:if test="${!pageInfo.isHasPreviousPage()}">class="disabled"</c:if>><a
                            href="${pageContext.request.contextPath}/flashcard/flashcardDetail/<c:out value="${pageInfo.pageNum-1}" />">Previous</a></li>
                    <!-- 中間頁數 -->
                    <c:forEach var="i" begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}">
                        <li <c:if test="${pageInfo.pageNum==i}">class="active"</c:if>><a
                                <c:if test="${pageInfo.pageNum==i}">class="hrefDisabled"</c:if>
                                href="${pageContext.request.contextPath}/flashcard/flashcardDetail/<c:out value="${i}" />">
                                <c:out value="${i}" />
                            </a></li>
                    </c:forEach>

                    <!-- 下一頁 -->
                    <li <c:if test="${!pageInfo.isHasNextPage()}">class="disabled"</c:if>><a
                            href="${pageContext.request.contextPath}/flashcard/flashcardDetail/<c:out value="${pageInfo.pageNum+1}" />">Next</a></li>

                    <!-- 最末頁 -->
                    <li <c:if test="${pageInfo.isIsLastPage()}">class="disabled"</c:if>><a
                            href="${pageContext.request.contextPath}/flashcard/flashcardDetail/<c:out value="${pageInfo.pages}" />">&raquo;</a></li>
                    <li></li>
                </ul>
            </li>
        </ul>
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