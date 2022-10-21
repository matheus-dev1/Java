<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Media Aluno Resultado</title>
	</head>
	<body>
		<%
			Integer numero1 = Integer.valueOf(request.getParameter("numero1"));
			Integer numero2 = Integer.valueOf(request.getParameter("numero2"));
			Integer soma = numero1 + numero2;
			Integer media = soma / 2;
			String alunoStatus;
			if (media >= 6) {
				alunoStatus = "Aluno Aprovado";
			} else {
				alunoStatus = "Aluno Reprovado";
			}
		%>
		<h1>Status Aluno: <%= alunoStatus %></h1>
	</body>
</html>