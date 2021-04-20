package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idAbitanteDaEliminare = Long.parseLong(request.getParameter("idAbitanteDelete"));

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();
		Abitante temp = null;
		RequestDispatcher rd = null;

		try {

			temp = abitanteServiceInstance.caricaSingoloElemento(idAbitanteDaEliminare);

			abitanteServiceInstance.rimuovi(temp);

		} catch (Exception e) {
			e.printStackTrace();
		}

		rd = request.getRequestDispatcher("searchForm.jsp");
		rd.forward(request, response);
	}

}
