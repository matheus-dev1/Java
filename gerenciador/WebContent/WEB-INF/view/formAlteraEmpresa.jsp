<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aplicação Gerenciador - Editar empresa</title>
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
				<input type="text" name="nome" value="${empresa.nome }" />
				<label>Data Abertura</label>
				<input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
				<input type="hidden" name="id" value="${empresa.id }">
				<input type="hidden" name="acao" value="AlteraEmpresa">
				<input class="btn btn-danger" type="submit" value="Alterar" />
			</form>
		</div>
	</body>
</html>