<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Par ou Impar</title>
	</head>
	<body>
		<form action="par-impar-resultado.jsp" method="get">
			<label>Digite um numero</label>
			<input name="numero" type="number"></input>
			<input type="submit" value="&DoubleRightArrow; Par ou impar?" />
		</form>
		<form action="menu.jsp" action="get">
			<input type="submit" value="Voltar" />
		</form>
	</body>
</html>