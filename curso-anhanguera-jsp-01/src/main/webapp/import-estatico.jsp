<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Import Estatico</title>
	</head>
	<body>
		<!-- Duas maneiras de importar um arquivo estatico -->
		<p><%@ include file="estatico.html" %> 1</p>
		<p><jsp:directive.include file="estatico.html"/> 2</p>
	</body>
</html>