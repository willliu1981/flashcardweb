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
	$("#draw").click(function() {
	  var $show = $("#show");
	  var $show2 = $("#show2");
	  $.ajax({
		type : "post",
		url : "${pageContext.request.contextPath}/process/card/draw",
		dataType : "json",
		success : function(data) {
		  //alert(data.name);
		  $show.val(data.name);
		  if (data.isLast) {
			$show2.val("最後一筆了");
		  }
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
		  //alert("error:" + textStatus);
		}
	  });

	});
  });
</script>
<style type="text/css">
.table_draw {
	border: 3px #0000FF solid;
}

.table_draw input {
	font-size: 36px;
	color: blue;
}

.table_draw input.red {
	color: red;
}
</style>
</head>
<body>
	<h1>test draw</h1>
	<table class="table_draw">
		<tr>
			<td><input type="button" id="draw" value="draw" /></td>
		</tr>
		<tr>
			<td><input type="text" id="show" /></td>
		</tr>
		<tr>
			<td><input type="text" id="show2" class="red" /></td>
		</tr>
	</table>
</body>
</html>