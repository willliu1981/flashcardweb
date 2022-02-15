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

	<a href="spring/hello">spring get all</a>
	</br> id
	<input type="text" id="uid" value="u_1001" />
	</br> name
	<input type="text" id="name" value="Kevin Wu" />
	</br> password
	<input type="text" id="password" value="kw123456" />
	</br>
	<button type="button" id="testajaxrestquery">test rest query</button>
	<br />
	<button type="button" id="testajaxput">test sprint put</button>
	<br />
	<button type="button" id="testajaxdelete">test sprint delete</button>
	<br />
	<a href="spring/hello?username=admin&password=123456">test spring
		mvc</a>

	<form action="spring/hello" method="post">
		<input type="text" name="username" value="abc" />
		<input type="text" name="password" value="123" />
		<input type="submit" value="test"></input>
	</form>
	<form action="spring/hello/u_1003" method="post">
		<input type="text" name="username" value="Peter" />
		<input type="text" name="password" value="p1234" />
		<input type="submit" value="test"></input>
	</form>
</body>
</html>