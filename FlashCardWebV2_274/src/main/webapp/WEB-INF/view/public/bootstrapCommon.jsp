<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css" href="${pageContext.request.contextPath}/css/EvenTable.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.cyborg.css">
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

</html>