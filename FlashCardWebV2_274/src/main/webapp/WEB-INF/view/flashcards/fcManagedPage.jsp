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
	$("#modal_fcTerm").text(term);
	$("#modal_fcDefinition").text(definition);
	$("#modal_form").attr("action", function(i, orig) {
	  return orig + id;
	});
  }
</script>

</head>
<body>
    <!-- 清單前往 web 的 path -->
    <c:set var="pathFlashcard" value="flashcard" />

    <!-- 分頁前往 web 的 base path -->
    <c:set var="pathForPager" value="flashcards/fcManager" />

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
                        <h4 class="h4" class="list-group-item-heading">
                            <c:out value="${fc.term}"></c:out>
                        </h4>
                        <p class="h4" class="list-group-item-text">
                            <c:out value="(id: ${fc.id}) ${fc.definition}"></c:out>
                        </p>
                    </a></li>
            </c:forEach>
        </ul>
    </div>

    <!-- 引入分頁  -->
    <jsp:include page="/WEB-INF/view/public/pager.jsp">
        <jsp:param name="webPath" value="flashcards/fcManager" />
    </jsp:include>

    <!-- 模態框 用於 list delete-->
    <div class="modal fade" tabindex="-1" role="dialog" id="listDeleteModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">Flashcard</h4>
                </div>
                <div class="modal-body">
                    <label id="modal_fcTerm" style="font-size: 20px;">term</label>
                    <br />
                    <label id="modal_fcDefinition" style="font-size: 20px;">definition</label>
                </div>
                <div class="modal-footer">
                    <form id="modal_form" action="${pageContext.request.contextPath}/flashcard/" method="post">
                        <input type="hidden" name="_method" value="delete" />
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            <font color="black">Close</font>
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