<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> Dettaglio abitante richiesto: </p>
	<% Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteDaInviareAPaginaDettalio"); %><br>
	Nome:<%= abitanteInPagina.getNome() %><br>
	Cognome: <%= abitanteInPagina.getCognome() %><br>
	Eta:<%= abitanteInPagina.getEta() %><br>
	Codice Fiscale: <%= abitanteInPagina.getCodiceFiscale() %><br>
	Motto di vita: <%= abitanteInPagina.getMottoDiVita() %><br>
</body>
</html>