<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>For dinamico com parametro</title>
	</head>
	<body>
		Processamento iniciado pela for-dinamico-com-parametro.jsp
		<!-- ${param.parametro} - Pega o primeiro valor, isso se tiver mais de 1-->
		<!-- ${paramValues.parametro} - Pega todos os valores e coloca em uma lista, podendo ser usado em um for -->
		<c:forEach var="item" items="${paramValues.parametro}">
  			<li>Valor de ${item}</li>
		</c:forEach>
	</body>
</html>