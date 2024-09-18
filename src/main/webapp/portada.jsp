<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Portada</title>
</head>
<body>


	<div>
		<a href="registrarNuevoSombrero.jsp">Registrar nuevo sombrero</a>
	</div>

	<h1>Listado de sombreros:</h1>
	<hr>
	<c:forEach items="${info_listado}" var="elemento">
		<div style="margin: 5px">
			Tipo: ${elemento.nombre} <br> 
			Descripcion: ${elemento.desc } <br>
			Precio: ${elemento.precio } euros
			<hr>
		</div>
	</c:forEach>
</body>
</html>