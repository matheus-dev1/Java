<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Par ou Impar Resultado</title>
	</head>
	<body>
		<% 
			int numero = Integer.valueOf(request.getParameter("numero"));
			String resposta = "";
			if (numero % 2 == 0) {
				resposta = "Par";
			} else {
				resposta = "Impar";
			}
		%>
		<h1>Resposta: <%= resposta %></h1>
		<form action="par-impar.jsp" method="get">
			<input type="submit" value="Voltar" />
		</form>
	</body>
</html>