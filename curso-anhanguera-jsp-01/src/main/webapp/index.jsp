<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Primeira p�gina JSP</title>
	</head>
	<body>
	<!-- No Java muitas coisas s�o feitas a partir de requisi��es, e na JSP, nos fazemos isso atraves de requisi��es AJAX ou formularios -->
		<form action="somar.jsp" method="get">
			<h1>Primeira p�gina JSP</h1>
			<input type="submit" value="Pr�xima p�gina">
		</form>
		<form action="menu.jsp" method="get">
			<h1>Menu</h1>
			<input type="submit" value="Menu">
		</form>
	</body>
</html>