<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Media Resultado</title>
	</head>
	<body>
		<%
			int numero1 = Integer.valueOf(request.getParameter("numero1"));
			int numero2 = Integer.valueOf(request.getParameter("numero2"));
			int numero3 = Integer.valueOf(request.getParameter("numero3"));
			Integer soma = numero1 + numero2 + numero3;
			Integer resultado = soma / 3;
		%>
		<h1>Resultado: <%= resultado %></h1>
	</body>
</html>