<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.admin_member
</style>
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
			$("#home").click(function() {
			  location.href = "${pageContext.request.contextPath}/index.jsp";
			});
			$("#edit")
				.click(
					function() {
					  location.href = "${pageContext.request.contextPath}/account/editMemberTransit.do";
					});
			$(".admin_member")
				.click(
					function(event) {
					  location.href = "${pageContext.request.contextPath}/account/editMemberTransit.do?id="
						  + $(event.target).attr("id");
					});
		  });
</script>
</head>
<body>
	<fieldset>
		<legend>會員資料</legend>
		<table>
			<tr>
				<td>名稱</td>
				<td>${user.displayName }</td>
			</tr>
			<tr>
				<td>帳號</td>
				<td>${user.username }</td>
			</tr>
			<tr>
				<td>權限</td>
				<td>${user.authority }</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${data.email }</td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<button type="button" id="home">回首頁</button>
		<button type="button" id="edit">修改會員資料</button>
	</fieldset>
	<br />
	<c:if test="${token.contains('read-user')}">
		<fieldset>
			<legend>管理會員資料 (${max }) </legend>
			<span> <c:if test="${ isFirst!=true}">
					<button type="button" id="previous">上一頁</button>
				</c:if> <input style="text-align: center" type="text" readonly id="page"
				size="3" value="${page }" /> <c:if test="${isLast!=true }">
					<button type="button" id="next">下一頁</button>
				</c:if>
			</span>
			<table style="border: 3px #cccccc solid" cellpadding="10" border="1">
				<tr>
					<th>id</th>
					<th>username</th>
					<th>display name</th>
					<th>email</th>
					<th>authority</th>
					<th>oper</th>
				</tr>
				<c:forEach var="i" begin="0" end="${users.size()-1 }">
					<tr>
						<td><c:out value="${users[i].u_id }" /></td>
						<td><c:out value="${users[i].username }" /></td>
						<td><c:out value="${users[i].displayName }" /></td>
						<td><c:out value="${userdatas[i].email }" /></td>
						<td><c:out value="${users[i].authority }" /></td>
						<c:if test="${token.contains('modify-member-user') }">
							<td><button class="admin_member" type="button" id="${users[i].u_id}">修改</button></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</c:if>

</body>
</html>