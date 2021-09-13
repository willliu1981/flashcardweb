<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="auth"
	uri="http://flashcard.ilan.com/tags/authorities"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>home</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(document)
      .ready(
          function() {
            
            $("#login")
                .click(
                    function() {
                      location.href = "${pageContext.request.contextPath}/login/login.jsp";
                    });

            $("#member")
                .click(
                    function() {
                      location.href = "${pageContext.request.contextPath}/account/member.do";
                    });
            $("#test")
                .click(
                    function() {
                      location.href = "${pageContext.request.contextPath}/servlet/TestServlet";
                    });
          });
</script>
</head>

<body>
	Home1
	<br>

	<c:choose>
		<c:when test="${not empty user}">
			${user.displayName}<br/>
			<button type="button" id="member">查詢會員資料</button>
		</c:when>
		<c:otherwise>
			<button type="button" id="login">登入</button>
		</c:otherwise>
	</c:choose>

	<br />
	<button type="button" id="test">Test</button>


</body>
</html>
