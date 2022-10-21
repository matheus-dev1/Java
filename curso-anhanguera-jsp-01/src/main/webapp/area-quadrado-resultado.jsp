<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Resultado da area do quadrado</title>
	</head>
	<body>
		<%
			Integer lado = Integer.valueOf(request.getParameter("numero"));
			Integer perimetro = lado * 4;
			Integer area = lado * lado;
		%>
		<h1>Perimetro: <%= perimetro %> - Area: <%= area %></h1>
	</body>
</html>