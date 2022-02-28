<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flash card v2</title>
<script
	src="<%=request.getContextPath()%>/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
	$("#send").click(function() {
	  var $vid=$("#vid").val();
	  window.location.href="<%=request.getContextPath()%>/page/vocabulary/query/"+$vid;
	})
  })
</script>
</head>
<body>
	<h1>Query Vocabulary</h1>
	<!--  
	<form action="<%=request.getContextPath()%>/vocabulary/query"
		method="post">
		<table>
			<tr>
				<td>vocabulary id</td>
				<td><input type="text" name="vid" id="vid" value="${vid}" /></td>
			</tr>
			<tr>
				<td><input type="button" value="send" id="send" /></td>
			</tr>
		</table>
	</form>
	-->
	
	<table>
			<tr>
				<td>vocabulary id</td>
				<td><input type="text" name="vid" id="vid" value="${vid}" /></td>
			</tr>
			<tr>
				<td><input type="button" value="send" id="send" /></td>
			</tr>
		</table>
</body>
</html>