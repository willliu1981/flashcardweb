<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
<style type="text/css">
.badgeSpan { /* 用於 list badge (delete)*/
	text-align: center;
	padding-left: 20px;
	padding-right: 20px;
}
</style>

<script type="text/javascript">
  //$("#listDeleteModal").model("hide");
  function modelValues(id, term, definition) {
	$("#model_id").val(id);
	$("#model_term").val(term);
	$("#model_definition").val(definition);
	$("#model_formID").attr("action", function(i, orig) {
	  return orig + id;
	});
  }

  $(document).ready(function() {

	/* $("#model_delete").click(function() {
	  location.href="${pageContext.request.contextPath}/fhashcard"
	}); */
  });
</script>

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
                        <span class="badge" style="background: red;" data-target="#listDeleteModal" data-toggle="modal"
                            onclick='modelValues("${fc.id}","${fc.term}","${fc.definition}")'>
                            <font size="4">DELETE</font>
                        </span>
                        <span class="badge badgeSpan"
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

    <!-- 模態框 用於 list delete-->
    <div class="modal fade" tabindex="-1" role="dialog" id="listDeleteModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">FlashCard</h4>
                </div>
                <div class="modal-body">

                    <input type="text" id="model_term" name="model_term" value="" />
                    <br />
                    <input type="text" id="model_definition" name="model_definition" value="" />
                </div>
                <div class="modal-footer">
                    <form id="model_formID" action="${pageContext.request.contextPath}/flashcard/" method="post">
                        <input type="hidden" id="model_id" name="model_id" value="" />
                        <input type="hidden" name="_method" value="delete" />
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            <font color="black"> Close</font>
                        </button>
                        <button id="model_delete" type="submit" class="btn btn-primary" style="background: red;">Delete
                            Data</button>
                    </form>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

</body>
</html>