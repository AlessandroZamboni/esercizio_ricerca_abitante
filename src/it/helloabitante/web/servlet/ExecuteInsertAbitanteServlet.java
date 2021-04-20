package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

/**
 * Servlet implementation class ExecuteInsertAbitanteServlet
 */
@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String nomeParameter = request.getParameter("nomeInputInsert");
		String cognomeParameter = request.getParameter("cognomeInputInsert");
		String etaParameter = request.getParameter("etaInputInsert");
		String codiceFiscaleParameter = request.getParameter("codiceFiscaleInputInsert");
		String mottoDiVitaParaMeter = request.getParameter("mottoDiVitaInputInsert");

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		String destinazione = null;
		RequestDispatcher rd = null;

		if (validazioneParametri(nomeParameter, cognomeParameter, etaParameter, codiceFiscaleParameter,
				mottoDiVitaParaMeter)) {

			try {
				Abitante temp = new Abitante();
				temp.setIdAbitante(DB_Mock.getNexIdAvailable());
				temp.setNome(nomeParameter);
				temp.setCognome(cognomeParameter);
				temp.setEta(Integer.parseInt(etaParameter));
				temp.setCodiceFiscale(codiceFiscaleParameter);
				temp.setMottoDiVita(mottoDiVitaParaMeter);
				abitanteServiceInstance.inserisciNuovo(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}

			destinazione = "searchForm.jsp";
		} else {
			destinazione = "insert.jsp";
		}

		rd = request.getRequestDispatcher(destinazione);

		rd.forward(request, response);
	}

	private boolean validazioneParametri(String nome, String cognome, String eta, String codiceFiscale,
			String mottoDiVita) {

		if (nome != null && cognome != null && eta != null && codiceFiscale != null && mottoDiVita != null
				&& !nome.isEmpty() && !cognome.isEmpty() && !eta.isEmpty() && !codiceFiscale.isEmpty()
				&& !mottoDiVita.isEmpty() && eta.matches("[0-9]+")) {

			return true;
		}

		return false;
	}

}
