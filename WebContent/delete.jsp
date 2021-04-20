<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Abitante</title>
</head>
<body>
	<p> Dettaglio abitante da eliminare: </p>
	<%  Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteDaEliminare"); %><br>
	<%= abitanteInPagina.getNome() %><br>
	<%= abitanteInPagina.getCognome() %><br>
	<%= abitanteInPagina.getEta() %><br>
	<%= abitanteInPagina.getCodiceFiscale() %><br>
	<%= abitanteInPagina.getMottoDiVita() %><br>
	
	<form action="ExecuteDeleteServlet" method="post">
		<input type="hidden" name="idAbitanteDelete" value="<%= abitanteInPagina.getIdAbitante() %>"><br>		
		<input type="submit" value="ELIMINA">			
	</form>
	<form action="SearchServlet" method="post">
		<input type="hidden" name="nomeInput" value="<%= abitanteInPagina.getNome() %>">		
		<input type="hidden" name="cognomeInput" value="<%= abitanteInPagina.getCognome() %>">	
		<input type="submit" value="ANNULLA">
	</form>
	
</body>
</html>
