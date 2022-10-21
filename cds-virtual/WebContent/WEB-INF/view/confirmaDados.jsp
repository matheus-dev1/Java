<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, br.com.devmedia.cdsvirtual.CD"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- 
		O useBean funciona como a instancia de uma classe, que voc� setou os dados dela em uma servlet e que enviou para uma jsp
		O uso � simples, tag jsp:useBean com o id que � como vc vai chamar o objeto
		class que � o full qualified name da classe
		e o scope, que � qual o escopo estamos buscando, neste caso da requisi��o.
		
		Depois disso tem a tag jsp:getProperty, que voc� faz o resgate deste dado, ent�o como � uma classe modelo
		eu estou pegando por exemplo o endereco, estou usando o objeto "usuario" e qual a propriedade eu quero resgatar "endereco"
	 -->
	<jsp:useBean id="usuario" class="br.com.devmedia.cdsvirtual.Usuario" scope="request"></jsp:useBean>
	<head>
		<title>Confirma��o dos Dados</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	</head>
  	<body>
  		<h2>Confirma��o dos dados</h2>
  		<table>
  		<tr>
        	<td>Nome:</td>
       		<td>${ usuario.nome }</td>
        	<!-- <td><jsp:getProperty name="usuario" property="nome"/></td> -->
      	</tr>
      	
      	<tr>
        	<td>Endere�o:</td>
        	<td><jsp:getProperty name="usuario" property="endereco"/></td>
      	</tr>
      	
      	<tr>
      		<td>N�mero do cart�o:</td>
       		<td><jsp:getProperty name="usuario" property="cartao"/></td>
      	</tr>
    	</table>
    
    	<br>
    	
    	<b>Lista de Cds</b>
    	<%
	      List<CD> cdsSelecionados = (List<CD>) request.getSession().getAttribute("cdsSelecionados");
	      request.setAttribute("listaCds", cdsSelecionados);
	      request.setAttribute("listaEditavel", false);
    	%>
    	<jsp:include page="catalogoCdsInclude.jsp"></jsp:include>
      	<p>Total da compra: <%= request.getAttribute("total") %></p>
  </body>
</html>