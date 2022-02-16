<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserttitlehere</title>
<script src="javascript/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
	var _uid = $("#uid").val();
	var _name = $("#name").val();
	var _pass = $("#password").val();
	$("#testajaxrestquery").click(function() {
	  $.ajax({
		url : "http://localhost:8080/SpringMVCTest/rest/user/" + _uid,
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

	$("#testajaxput").click(function() {
	  $.ajax({
		url : "spring/user",
		data : JSON.stringify({
		  "uid" : _uid,
		  "name" : _name,
		  "password" : _pass
		}),
		type : "PUT",
		dataType : "json",
		success : function(res) {
		  alert(res);
		},
		error : function(error) {
		  console.log(error);
		}
	  });
	});

	$("#testajaxdelete").click(function() {
	  $.ajax({
		url : "spring/user",
		data : _uid,
		type : "DELETE",
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

	<a href="spring2/test3?name=Ken&password=123&name=David">spring get
		all</a>
	</br> id

	<form action="spring2/test4" method="post">
		<input type="text" name="uid" value="u_1004" />
		<input type="text" name="name" value="Lili" />
		<input type="text" name="username" value="l123456" />
		<input type="text" name="password" value="li1234" />
		<input type="text" name="address.address1" value="ilan1" />
		<input type="text" name="address.address2" value="ilan2" />

		<input type="submit" value="spring create"></input>
	</form>
</body>
</html>