<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Import Dinamico</title>
	</head>
	<body>
		<jsp:include page="for-dinamico.jsp" flush="true" />
		<p>For terminado!!!</p>
		<jsp:include page="for-dinamico-com-parametro.jsp" flush="true">
			<jsp:param value="Matheus" name="parametro"></jsp:param>
			<jsp:param value="Silva" name="parametro"></jsp:param>
		</jsp:include>
	</body>
</html>