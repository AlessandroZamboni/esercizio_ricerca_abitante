package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		return DB_Mock.LISTA_ABITANTI;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		if (id == null || id < 0)
			throw new Exception("Input non valido.");

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (id.equals(abitanteItem.getIdAbitante())) {
				return abitanteItem;
			}
		}

		return null;
	}

	@Override
	public int update(Abitante input) throws Exception {
		if (input == null)
			throw new Exception("Input non valido.");

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (input.getIdAbitante().equals(abitanteItem.getIdAbitante())) {
				abitanteItem.setNome(input.getNome());
				abitanteItem.setCognome(input.getCognome());
				abitanteItem.setEta(input.getEta());
				abitanteItem.setCodiceFiscale(input.getCodiceFiscale());
				abitanteItem.setMottoDiVita(input.getMottoDiVita());

				return 1;
			}
		}

		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		if (input == null)
			throw new Exception("Input non valido.");

		input.setIdAbitante(DB_Mock.getNexIdAvailable());
		DB_Mock.LISTA_ABITANTI.add(input);

		return 1;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		if (input == null || input.getIdAbitante() == null) {
			throw new Exception("input non valido");
		}

		int i = 0;
		int k = -1;
		for (i = 0; i < DB_Mock.LISTA_ABITANTI.size(); i++) {
			if (DB_Mock.LISTA_ABITANTI.get(i).getIdAbitante().equals(input.getIdAbitante())) {
				k = i;
			}
		}

		if (k != -1) {
			DB_Mock.LISTA_ABITANTI.remove(k);
			return 1;
		}

		return 0;
	}

}
