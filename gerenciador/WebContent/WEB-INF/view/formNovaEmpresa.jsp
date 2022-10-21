<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aplicação Gerenciador - Criar empresa</title>
		<link 
			rel="stylesheet" 
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
			crossorigin="anonymous"
		>
		<style type="text/css">
			a {
				color: white;
				
			}
			button {
				height: 40px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<c:import url="logout-parcial.jsp"/>
			<form action="${linkEntradaServlet}" method="post">
				<label>Nome</label>
				<input type="text" name="nome" placeholder="nome da empresa" />
				<label>Data Abertura</label>
				<input type="text" name="data" placeholder="data da criação" />
				<input type="hidden" name="acao" value="NovaEmpresa" />
				<input class="btn btn-success" type="submit" value="Cadastrar"/>
			</form>
		</div>
	</body>
</html>