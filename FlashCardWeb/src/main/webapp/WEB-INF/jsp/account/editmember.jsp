<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(document)
	  .ready(
		  function() {
			$("#previous")
				.click(
					function() {
					  var page = parseInt($("#page").val());
					  location.href = "${pageContext.request.contextPath}/account/member.do?page="
						  + (page - 1);
					});

			$("#next")
				.click(
					function() {
					  var page = parseInt($("#page").val());
					  location.href = "${pageContext.request.contextPath}/account/member.do?page="
						  + (page + 1);
					});
			$("#home")
				.click(
					function() {
					  location.href = "${pageContext.request.contextPath}/index.jsp;
					});
			$("#edit")
				.click(
					function() {
					  location.href = "${pageContext.request.contextPath}/account/editMemberTransit.do;
					});
		  });
</script>
</head>
<body>
	<fieldset>
		<legend>修改會員資料</legend>
		<form action="${pageContext.request.contextPath}/account/editMember.do" method="post">
			<table>
				<tr>
					<td>名稱</td>
					<td><input type="text" value="${user.displayName }"
						name="displayName" /></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="password" value="${user.password }"
						name="password" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" value="${data.email }" name="email" /></td>
				</tr>
			</table>
			<input type="submit" value="確定修改" />
		</form>

	</fieldset>
	<fieldset>
		<button type="button" id="home">回首頁</button>
		<button type="button" id="member">返回會員資料</button>
	</fieldset>


</body>
</html>