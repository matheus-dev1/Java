<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- 
O @ significa que eh uma declaracao da pagina. 

taglib significa que eh uma biblioteca de tags.

As biblioteca de tags sao definidas pela uri=""

Eu tenho que definir um prefixo, onde basicamente toda tag deste lib que eu usar eu tenho que colocar o 
prefixo(c):nome_da_tag, para o JSTL, normalmente usam "c".
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>
			JSTL - JavaServer Standar Taglib
		</title>
	</head>
	<body>
		<ul>
			<!-- 
				<%
					List<Empresa> listaEmpresas = (ArrayList<Empresa>) request.getAttribute("listaEmpresas");
						for (Empresa empresa : listaEmpresas) {
				%>
				
				<li> <%= empresa.getNome() %> </li>
				
				<% } %> 
			-->
		
			<!-- 
			Tag do ForEach
			
			A prorpiedade items que tenho que colocar em forma de ${} os items que eu quero iterar.
			A var eh o nome que voce vai dar pra cada item.
			-->
			
			<a:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome}</li>
			</a:forEach>
			
		</ul>
	</body>
</html>