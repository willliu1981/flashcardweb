<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserttitlehere</title>
<script src="javascript/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(document).ready(
	  function() {
		var uid = $("#uid").val();
		var name = $("#name").val();
		var pass = $("#password").val();
		$("#testajax").click(function() {
		  $.ajax({
			url : "http://localhost:8080/SpringMVCTest/rest/user/" + uid,
			type : "GET",
			dataType : "text",
			success : function(res) {
			  alert(res);
			},
			error : function(error) {
			  console.log(error);
			}
		  });
		});

		$("#testajax2").click(
			function() {
			  $.ajax({
				url : "http://localhost:8080/SpringMVCTest/spring/user?uid="
					+ uid + "&name=" + name + "&password=" + pass,
				type : "PUT",
				dataType : "text",
				success : function(res) {
				  alert(res);
				},
				error : function(error) {
				  console.log(error);
				}
			  });
			});
	  });
</script>
</head>
<body>
	<h1>hello java xxx2</h1>
	</br> id
	<input type="text" id="uid" value="u_1001" />
	</br> name
	<input type="text" id="name" value="Kevin Wu" />
	</br> password
	<input type="text" id="password" value="kw123456" />
	</br>
	<button type="button" id="testajax">test ajax</button>
	<br />
	<button type="button" id="testajax2">test ajax 2</button>
	<br />
	<a href="spring/hello?username=admin&password=123456">test spring
		mvc</a>

	<form action="hello" method="post">
		<input type="text" name="username" value="abc" /> <input type="text"
			name="password" value="123" /> <input type="submit" value="test"></input>
	</form>
</body>
</html>