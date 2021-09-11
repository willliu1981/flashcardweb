<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
  $(document)
      .ready(
          function() {
            $("#username")
                .change(
                    function() {
                      var username = $("#username").val();
                      var settings = {
                        url : 'http://localhost:8080/FlashCardWeb/account/judgeUser.do?username='
                            + username,
                        type : 'GET',
                        success : function(result, status, xhr) {
                          var valid;
                          $.each(result, function(key, value) {
                            valid = value;
                          });
                          if ($.trim(valid) == 'true') {
                            $('#usernameerrormsg').text('可用ID').css('color',
                                'green');
                          } else {
                            $('#usernameerrormsg').text('無效ID').css('color',
                                'red');
                          }
                        },
                        error : function(xhr, status, error) {
                          alert('error');
                        }
                      };
                      $.ajax(settings);

                    });
          });
</script>
</head>
<body>
	<fieldset>
		<legend>註冊帳號</legend>
		<form id="formRegister"
			action="${pageContext.request.contextPath}/RegisterServlet"
			method="post">
			<table style="text-align:center">
				<tr>
					<td>帳號</td>
					<td><input type="text" id="username" name="username"></td>
					<td><label id="usernameerrormsg"></label></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="text" name="password"></td>
					<td><label id="passworderrormsg"></label></td>
				</tr>
				<tr>
					<td>名稱</td>
					<td><input type="text" name="displayname"></td>
					<td><label id="displaynameerrormsg"></label></td>
				</tr>
				<tr>
					<td>電子信箱</td>
					<td colspan="2"><input type="text" name="email"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="送出"></td>
				</tr>

			</table>

		</form>
	</fieldset>
</body>
</html>