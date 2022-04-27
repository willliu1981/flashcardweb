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
					  var $count = $("#count").val();
					  window.location.href =
<%out.print(String.format("'%s'", request.getContextPath()));%>
  + "/process/exam/count/" + $count;
					});
		  });
</script>
</head>
<body>
	<h1>Exam</h1>
	<table>
		<tr>
			<td>how many?</td>
			<td><input type="text" id="count" value="${count}" /></td>
		</tr>
		<tr>
			<td style="text-align: center" colspan="2"><input type="button" id="send"
					value="send" /></td>
		</tr>
	</table>

</body>


</body>
</html>