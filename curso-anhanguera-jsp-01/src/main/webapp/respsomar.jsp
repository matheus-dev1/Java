<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Resposta do somar</title>
	</head>
	<body>
		<%
			// Scriplet - Aqui estou executando codigo puramente Java
			// Estou resgatanto os valores dos dois inputs de uma requisição forward vindo de um form com metodo post
			int valor1 = Integer.valueOf(request.getParameter("valor1"));
			int valor2 = Integer.valueOf(request.getParameter("valor2"));
			int resultado = valor1 + valor2;
		%>
		<!-- Expressão, basicamente exibindo o resultado. -->
		<h1>Resultado: <%= resultado %></h1>
		<form action="somar.jsp" method="get">
			<input type="submit" value="&DoubleLeftArrow; Voltar" />
		</form>
	</body>
</html>