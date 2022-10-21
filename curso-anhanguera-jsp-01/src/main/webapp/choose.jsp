<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Choose JSTL</title>
	</head>
	<body>
		<!-- Aqui eu estou setando 3 variaveis diferentes em tres escopos diferentes da minha aplicação -->
		<c:set var = "numero-session" scope = "session" value = "${2+2}"/>
		<c:set var = "numero-application" scope = "application" value = "${2000+1}"/>
		 <c:set var = "numero-request" scope = "request" value = "${3+3}"/>
		
		<c:choose>
			<c:when test="${numero-session >= '2001'}" >
				<c:out value="true1" />
			</c:when>
			
			<c:when test="${numero-session <= '4'}" >
				<c:out value="false0" />
			</c:when>
			
			<c:otherwise>
				<c:out value="Operação inválida!" />
  			</c:otherwise>
		</c:choose>
	</body>
</html>