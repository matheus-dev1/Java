<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Primeira página JSP</title>
	</head>
	<body>
	<!-- No Java muitas coisas são feitas a partir de requisições, e na JSP, nos fazemos isso atraves de requisições AJAX ou formularios -->
		<form action="somar.jsp" method="get">
			<h1>Primeira página JSP</h1>
			<input type="submit" value="Próxima página">
		</form>
		<form action="menu.jsp" method="get">
			<h1>Menu</h1>
			<input type="submit" value="Menu">
		</form>
	</body>
</html>