<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<% /* Java Server Pages Standard Tag Library - FMT - Tags para formatação e internacionalização de dados */ %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% /* Essa é a captura do request.setAttribute("empresas", lista); no formato List<Empresa> */ %>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aplicação Gerenciado - Listagem de Empresas</title>
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
			<% /* Podemos importar um "componente" a partir da "taglib" core */ %>
			<core:import url="logout-parcial.jsp"/>
			<button class="btn btn-info">
				<a target="_blank" href="/gerenciador/empresas">Empresas XML</a>
			</button>
			
			<% /* Este dado foi setado na sessão, então posso captura-lo sem importar */ %>
			<p>Usuario Logado: <b>${usuarioLogado.login}</b></p>
			
			<% /* O atributo "empresa" foi setado no arquivo MostraEmpresaServlet */ %>
			<% /* Aqui ele ta testando se o atributo "empresa" não está vazio. */ %>
			<core:if test="${not empty empresa}">
				<p>Empresa ${ empresa } cadastrada com sucesso!</p>
			</core:if>
			<p>Lista de empresas:</p>
			<ul>
			<% /* Essa variavel so existe se eu passar pelo fluxo /entrada/ListaEmpresa.java e setar o atributo setAttibute */ %>
				<% /* E aqui eu estou fazendo um forEach, onde cada objeto passa a ter o nome no singular, ou seja, "empresa" */ %>
				<core:forEach items="${empresas}" var="empresa">
					<li>
						<% /* Para fazer um "get" você pode usar o .getNome(), ou apenas .nome */ %>
						${empresa.nome} - 
						<% /* Lib para formatação e internacionalização de dados, nesta caso to formatando uma data */ %>
						<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> - 
						<button class="btn btn-success">
							<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
						</button>
						<button class="btn btn-danger">
							<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remover</a>
						</button>
						<br />
					</li>
				</core:forEach>
			</ul>
		</div>
	</body>
</html>