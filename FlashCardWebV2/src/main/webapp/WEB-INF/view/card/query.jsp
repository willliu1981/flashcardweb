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
  $(document)
	  .ready(
		  function() {
			$("#send")
				.click(
					function() {
					  var $cid = $("#cid").val();
					  window.location.href =
<%out.print(String.format("'%s'", request.getContextPath()));%>
  + "/process/card/query/" + $cid;
					});
		  });
</script>
</head>
<body>
	<h1>Query Card</h1>
	<table>
		<tr>
			<td>card id</td>
			<td><input type="text" name="cid" id="cid" value="${cid}" /></td>
		</tr>
		<tr>
			<td><input type="button" id="send" value="send" /></td>
		</tr>
	</table>

</body>
</html>