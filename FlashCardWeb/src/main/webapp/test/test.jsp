<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<script type="text/javascript" language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(document)
	  .ready(
		  function() {
			$("#test")
				.click(
					function() {
					  var va = parseInt($("#va").val());
					  location.href = "${pageContext.request.contextPath}/test/test.do?v="
						  + (va + 1);
					});
		  });
</script>
</head>
<body>
	<input type="text" id="va" />
	<button type="button" id="test">test</button>
</body>
</html>
