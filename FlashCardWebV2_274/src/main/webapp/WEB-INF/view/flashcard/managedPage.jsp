<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/EvenTable.css">
</head>
<body>

	<div>
		<h1>FlashCard Manager</h1>
		<table class="evenTable">
			<tr>
				<td><font size="6" color="blue">FlashCard Manager</font>
			</tr>
			<tr>
				<td
					onclick="window.location.href='${pageContext.request.contextPath}/flashcard/flashcardDetail';"><font
					size="6" color="blue">FlashCard</font>
			</tr>
			<tr>
				<td
					onclick="window.location.href='${pageContext.request.contextPath}/flashcard/handledCardDetail';"><font
					size="6" color="blue">HandledCard</font>
			</tr>

		</table>
	</div>




</body>
</html>