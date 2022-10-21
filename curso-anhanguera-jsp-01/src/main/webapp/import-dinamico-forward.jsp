<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Import Dinamico Forward</title>
	</head>
	<body>
		<!-- Este paragrafo n'ao vai ser exibido, por que o forward, tomou o controle da requisição e finalizou ela. -->
		<jsp:forward page="jsp-dinamico-forward.jsp"></jsp:forward>
		<p>Teste que deve falhar!!!</p>
	</body>
</html>