<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Portada</title>
</head>
<body>
	<%
	/**Solo por hoy vamos a usar estos simbolos, los cuales son un desastre
	proque me permiten meter aqui, en la parte de vista, cualquier codigo java*/
	ArrayList<String> sombreros = (ArrayList<String>) request.getAttribute("info_listado");
	for (String s : sombreros) {
		out.print(s + "<br>");
	}
	//todo esto, mañana desaparece, no hay que inscrustar java en jsp
	%>
	Listado de sombreros (por hacer...)
</body>
</html>