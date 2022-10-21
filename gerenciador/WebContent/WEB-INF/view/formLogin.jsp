<% /* Encondig da pagina, ou seja, ela vai respeira os caracteres da ISO-8859-1*/ %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% /* A tag <c:url> formata uma URL em uma string e a armazena em uma variável. */ %>
<c:url value="/entrada" var="linkEntradaServlet" /> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aplicação Gerenciador - Login</title>
		<link 
			rel="stylesheet" 
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
			crossorigin="anonymous"
		>
	</head>
	<body>
		<div class="container">
			<% /* A action é para onde os dados serão enviados, neste caso http://localhost:8080/gerenciador/entrada
			passando por baixo dos passo login=1234&?senha=12345, não pela URL */ %>
			<form action="${linkEntradaServlet}" method="post">
				<label>Login</label>
				<input type="text" name="login" />
				<label>Senha</label>
				<input type="password" name="senha" />
				<input type="hidden" name="acao" value="Login" />
				<input class="btn btn-success" type="submit" value="Entrar" />
			</form>
		</div>
	</body>
</html>