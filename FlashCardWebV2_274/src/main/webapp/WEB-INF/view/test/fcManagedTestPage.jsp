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
    <!-- 清單 前往 web 的 path -->
    <c:set var="pathForList" value="flashcard" scope="request"/>

    <!-- 分頁 前往 web 的 base path -->
    <c:set var="pathForPager" value="flashcards/fcManager" scope="request" />

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="flashcardManager" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="管理 Flashcard" />
    </jsp:include>

    <!-- 引入 list -->
    <jsp:include page="/WEB-INF/view/public/listForTest.jsp"></jsp:include>

    <!-- 引入分頁  -->
    <jsp:include page="/WEB-INF/view/public/pager.jsp"></jsp:include>

</body>
</html>