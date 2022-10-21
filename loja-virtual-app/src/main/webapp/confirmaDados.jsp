<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, br.com.devmedia.lojavirtual.CD"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

  <jsp:useBean id="usuario" class="br.com.devmedia.lojavirtual.Usuario" scope="request"></jsp:useBean>

  <head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  </head>

  <body>

    <h2>Confirmação dos dados</h2>



    <table>

      <tr>

        <td>Nome:</td>

        <td><jsp:getProperty name="usuario" property="nome"/></td>

      </tr>

      <tr>

        <td>Endereço:</td>

        <td><jsp:getProperty name="usuario" property="endereco"/></td>

      </tr>

      <tr>

        <td>Número do cartão:</td>

        <td><jsp:getProperty name="usuario" property="numeroCartao"/></td>

      </tr>

    </table>

    <br><b>Lista de Cds</b>

    <%

      List<CD> cdsSelecionados = (List<CD>) request.getSession().getAttribute("cdsSelecionados");

      request.setAttribute("listaCds", cdsSelecionados);

      request.setAttribute("listaEditavel", false);

    %>

    <jsp:include page="catalogoCdsInclude.jsp"></jsp:include>

      Total da compra: <%=request.getAttribute("total") %>

    <br><br><input type="submit" value="Confirmar dados">

  </body>

</html>