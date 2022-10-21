<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SOMAR DOIS VALORES</title>
	</head>
	<body>
		<form action="respsomar.jsp" method="post">
			<h1>SOMAR DOIS VALORES</h1>
			<label>Digite o primeiro valor:</label>
			<input name="valor1" type="number" size="10" maxlength="2"/>
			<br/>
			<label>Digite o segundo valor: </label>
			<input name="valor2" type="number" size="10" maxlength="2"/>
			<br/>
			<!-- Em formularios nos usamos inputs em vez de buttons -->
			<input type="submit" value="&DoubleRightArrow; Somar" />
		</form>
		<form action="index.jsp" method="get">
			<input type="submit" value="&DoubleLeftArrow; Voltar " />
		</form>
	</body>
</html>