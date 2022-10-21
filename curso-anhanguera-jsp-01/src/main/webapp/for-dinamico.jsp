<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>For dinamico</title>
	</head>
	<body>
		Processamento iniciado pela for-dinamico.jsp
		<% for(int count = 0; count < 100; count++){ %>
		<%= "Valor de " + count %>
		<br/>
		<% } %>
	</body>
</html>