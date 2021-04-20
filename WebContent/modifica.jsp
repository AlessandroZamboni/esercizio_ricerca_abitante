<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Abitante</title>
</head>
<body>
	<%  Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteDaModificare"); %>
	<form action="ExecuteUpdateAbitanteServlet"  method="post">
	
		<label for="nomeInput">NOME:</label><br>
			<input type="text" required name="nomeUpdate"><br>
		<label for="cognomeInput">COGNOME:</label><br>
			<input type="text" required name="cognomeUpdate"><br>
		<label for="etaInput">ETA:</label><br>
			<input type="text" pattern="[0-9]+" title="Il campo deve contenere un numero" required name="etaUpdate"><br>
		<label for="codiceFiscaleInput">CODICE FISCALE:</label><br>
			<input type="text" required name="codiceFiscaleUpdate"><br>
		<label for="mottoDiVitaInput">MOTTO DI VITA:</label><br>
			<input type="text" required name="mottoDiVitaUpdate"><br>				
		<input type="hidden" name="idAbitanteUpdate" value="<%= abitanteInPagina.getIdAbitante() %>">		
		<br><br>
		<input type="submit" value="MODIFICA">	
	</form>	<br>
	
	<form action="SearchServlet" method="post">
		<input type="hidden" name="nomeInput" value="<%= abitanteInPagina.getNome() %>">		
		<input type="hidden" name="cognomeInput" value="<%= abitanteInPagina.getCognome() %>">	
		<input type="submit" value="ANNULLA">
	</form>
</body>
</html>