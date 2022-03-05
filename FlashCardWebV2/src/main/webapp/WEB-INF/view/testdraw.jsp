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
	var $vocabulary;
	var $translation;
	var $flipIndex;
	var $flip = $("#flip");

	$("#draw").click(function() {
	  var $msg = $("#msg");
	  $.ajax({
		type : "post",
		url : "${pageContext.request.contextPath}/process/card/draw",
		dataType : "json",
		success : function(data) {
		  //alert(data.name);
		  $flip.val($vocabulary = data.vocabulary);
		  $translation = data.translation;
		  $flipIndex = 0;
		  if (data.isLast) {
			$msg.val("最後一筆了");
		  }
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
		  //alert("error:" + textStatus);
		}
	  });

	});

	$flip.click(function() {
	  $flipIndex = 1 - $flipIndex;
	  if ($flipIndex == 0) {
		$(this).val($vocabulary);
	  } else {
		$(this).val($translation);
	  }

	});
  });
</script>

<style type="text/css">
.table_draw {
	border: 3px #0000FF solid;
	margin-left: auto;
	margin-right: auto;
	padding: 12px;
}

.table_draw input {
	font-size: 36px;
	color: blue;
	width: 100%;
}
</style>

</head>
<body>
	<h1 style="text-align: center">test draw</h1>
	<table class="table_draw">
		<tr>
			<td colspan="2" align="right"><input type="button" id="draw"
					value="draw" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" id="flip"
					style="height: 240px; text-align: center" readonly /></td>
		</tr>
		<tr>
			<td><input type="button" id="move-left" value="✘"
					style="color: red" /></td>
			<td><input type="button" id="move-right" value="✔"
					style="color: green" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" id="msg" style="color: red" /></td>
		</tr>
	</table>
</body>
</html>