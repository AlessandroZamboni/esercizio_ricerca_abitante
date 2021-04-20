package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);
	
	public List<Abitante> listAll() throws Exception;

	public Abitante caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Abitante abitanteInstance) throws Exception;

	public void inserisciNuovo(Abitante abitanteInstance) throws Exception;

	public void rimuovi(Abitante abitanteInstance) throws Exception;

	public List<Abitante> cercaPerNomeECognome(String nome, String cognome);
}
