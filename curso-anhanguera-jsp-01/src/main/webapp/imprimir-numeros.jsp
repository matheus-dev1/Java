<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Imprimir numeros</title>
	</head>
	<body>
		<h2>Contador de numeros</h2>
		<%
			for(int i = -56; i < 1000; i ++){
		%>
			<%= i %>
		<% 
			}
		%>
	</body>
</html>