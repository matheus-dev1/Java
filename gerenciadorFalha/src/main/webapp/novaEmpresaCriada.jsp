<!--
Todo codigo java dentro de arquivo .JSP ficam dentro de scriptlet é todo o conteúdo que está dentro das tags <%%> 

Este codigo eh intrepertado no lado do servidor(server side) e me retorna dinamicamente a pagina.

Nele nos colocamos os importes necessarios tambem.
-->
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<% 
	String alura = "alura";
	System.out.print(alura);
%>

<%
	// Capturando o setAtribute que foi enviado pelo .forward da classe NovaEmpresaServlet.java
	// String empresa = (String) request.getAttribute("empresa");
	// System.out.print(empresa);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- JSPWriter - objeto de sair de dados do JSP. -->
		<title><% out.print(alura); %></title>
	</head>
	<body>
		<!-- Encurtamento do out.println(variavel) -->
		<h1><%= alura %></h1>
		<!-- Faz a mesma coisa que a linha de cima mas de uma forma mais simplificada, porque eu nao preciso
		usar o metodo getAttribute 
		
		Interpretar uma expressao e o resultado sera exibido. -->
		<h2>${empresa}</h2>
	</body>
</html>