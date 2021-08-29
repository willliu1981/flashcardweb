<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page
	import="com.ilan.model.user.*,com.ilan.control.authority.*,com.ilan.control.authority.Authorization.*"%>
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
	Home
	<br>

	<%
	User user = null;
		if ((user = (User) session.getAttribute("user")) == null || !Authorities.hasAuthorization(
		Authorities.toAuthority(user.getAuthority()).getAuthority_member(), Member.READCARD)) {
	%>
	<button type="button" id="login">登入</button>
	<%
	} else {
	%>
	<fieldset>
		<legend><%=user.getDisplayName()%></legend>
	</fieldset>
	<%
	}
	%>
</body>
</html>
