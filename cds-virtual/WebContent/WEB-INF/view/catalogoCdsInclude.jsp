<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1">
	<tr>
		<!-- requestScope é um objeto global para a captura de atributos setados na requisição.
		Neste caso a JSp catalogoCds setou dois atributos e fez um include desta jsp nela, então esta pagina
		tem os atributos setados.  -->
		<c:if test="${requestScope.listaEditavel}">
			<td>&nbsp;</td>
    	</c:if>
    	<td>Código</td><td>Título</td><td>Artista</td><td>Preço</td>
	</tr>
	<c:forEach var="cd" items="${requestScope.listaCds}">
		<tr>
      		<c:if test="${requestScope.listaEditavel}">
        		<td><input type="checkbox" name="chkCodigosCds" value="${cd.codigo}"></td>
      		</c:if>
      		<td>${cd.codigo}</td>
      		<td>${cd.titulo}</td>
      		<td>${cd.artista}</td>
      		<td>${cd.preco}</td>
    	</tr>
    </c:forEach>
    <!-- testando 1 = ${catalogoCds[1].codigo} -->
</table>