<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" 
	import="java.util.HashMap, br.com.devmedia.lojavirtual.CD"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<h2>Lista de CDs</h2>
		<form name=formLista action='/LojaVirtualJSP/dadosCompra' method=POST>
			<%
				//adiciona os parâmetros no request para a criação da tabela com os cds
				HashMap<Long, CD> mapCds = (HashMap<Long, CD>) application.getAttribute("catalogoCds");
				request.setAttribute("listaCds", mapCds.values());
				request.setAttribute("listaEditavel", true);
	       	%>
	       	<jsp:include page="catalogoCdsInclude.jsp"></jsp:include>
	      	<input type="submit" value="Adicionar ao carrinho">
    	</form>
	</body>
</html>