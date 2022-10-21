<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Media Ponderada Resultado</title>
	</head>
	<body>
		<%
			Integer numero1 = Integer.valueOf(request.getParameter("numero1"));
			Integer numero2 = Integer.valueOf(request.getParameter("numero2"));
			Integer numero3 = Integer.valueOf(request.getParameter("numero3"));
			Integer media = (numero1 * 2 + numero2 * 3 + numero3 * 7) / 12;
		%>
		<h1>Media Ponderada: <%= media %></h1>
	</body>
</html>