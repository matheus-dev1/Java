<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1">
	<tr>
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
</table>