<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page
	import="com.ilan.model.user.*,com.ilan.control.authority.*,
	com.ilan.control.authority.Authorization.*,com.ilan.control.authority.Authorization"%>
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
	$(document).ready(function() {
		$("#login").click(function() {
			location.href = "${pageContext.request.contextPath}/login/login.jsp";
		});
	});
</script>
</head>

<body>
	Home2
	<br>
	<%
	request.setAttribute("ss", Authorization.Member.CREATECARD);
	%>

	<jsp:useBean id="a" class="com.ilan.control.authority.Authorization"></jsp:useBean>
	<jsp:useBean id="o" class="com.ilan.control.authority.OutClass"></jsp:useBean>


	auth1: ${auth:getMsg(ss)}
	<br /> auth2: ${OutClass.InClass.msgHi }
	<br /> auth3: ${OutClass.msgHello }
	<br /> auth4: ${OutClass.getHello() }
	<br /> auth5: ${Msg.Hello }
	<br />



	<c:choose>
		<c:when test="${not empty user}">
        	${user.displayName }
        	
    	</c:when>
		<c:otherwise>
			<button type="button" id="login">登入</button>
		</c:otherwise>
	</c:choose>





</body>
</html>
