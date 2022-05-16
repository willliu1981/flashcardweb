<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ls" uri="https://idv.kw/tags/list"%>
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
  
</script>

</head>
<body>
    <!-- title -->
    <c:set var="title" value="Flashcard" scope="request" />

    <!-- 清單 前往 web 的 base path -->
    <c:set var="pathForList" value="flashcard" scope="request" />

    <!-- 分頁 前往 web 的 base base path -->
    <c:set var="pathForPager" value="flashcards/fcManager" scope="request" />

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="flashcardManager" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="管理 ${title}" />
    </jsp:include>



    <!-- 引入 list -->
    <%-- <jsp:include page="/WEB-INF/view/public/test/listForTest2.jsp"></jsp:include> --%>

    <!-- 引入分頁  -->
    <jsp:include page="/WEB-INF/view/public/pager.jsp"></jsp:include>

</body>
</html>