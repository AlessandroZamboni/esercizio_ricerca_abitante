<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Nuovo Abitante</title>
</head>
<body>
	<form action="ExecuteInsertAbitanteServlet" method="post">
	
		<label for="nomeInputInsert">NOME:</label><br>
			<input type="text" name="nomeInputInsert"><br>
		<label for="cognomeInputInsert">COGNOME:</label><br>
			<input type="text"  name="cognomeInputInsert"><br>
		<label for="cognomeInputInsert">ETA:</label><br>
			<input type="text" name="etaInputInsert"><br>
		<label for="codiceFiscaleInputInsert">CODICE FISCALE:</label><br>
			<input type="text" name="codiceFiscaleInputInsert"><br>
		<label for="mottoDiVitaInputInsert">MOTTO DI VITA:</label><br>
			<input type="text" name="mottoDiVitaInputInsert"><br>		
		
		<br><br>
		<input type="submit" value="INSERISCI">	
	</form>
</body>
</html>