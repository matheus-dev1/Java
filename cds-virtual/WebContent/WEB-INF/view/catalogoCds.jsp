<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" 
	import="java.util.HashMap, br.com.devmedia.cdsvirtual.CD"
%>
<!-- A propriedade import, faz o import de classes Java, para dentro da JSP -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de CDs</title>
	</head>
	<body>
		<h2>Lista de CDs</h2>
		<form name=formLista action='/cds-virtual/dadosCompra' method=POST>
			<%
				/* Aqui eu estou pegando do contexto da aplicação o atributo "catalogoCds", e fazendo um 
				casting para o tipo HashMap */
				HashMap<Long, CD> mapCds = (HashMap<Long, CD>) application.getAttribute("catalogoCds");
				/* Aqui eu estou setando dois atributos na requisição, e quem vai usar estes valores é a 
				JSP catalogoCdsInclude.jsp */
				request.setAttribute("listaCds", mapCds.values());
				request.setAttribute("listaEditavel", true);
	       	%>
	       	<!-- Incluindo esta pagina, ela recebe os atributos setados na request. -->
	       	<jsp:include page="catalogoCdsInclude.jsp"></jsp:include>
	      	<input type="submit" value="Adicionar ao carrinho" />
    	</form>
	</body>
</html>