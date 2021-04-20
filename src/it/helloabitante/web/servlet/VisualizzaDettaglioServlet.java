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

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaDettaglioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");

		RequestDispatcher rd = null;
		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();
		Abitante result = null;

		try {
			result = abitanteServiceInstance
					.caricaSingoloElemento(Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("abitanteDaInviareAPaginaDettalio", result);

		response.getWriter()
				.append("Volevi visualizzare abitante con id: " + parametroIdDellAbitanteDiCuiVoglioIlDettaglio)
				.append(request.getContextPath());

		if (result == null)
			rd = request.getRequestDispatcher("searchForm.jsp");
		else
			rd = request.getRequestDispatcher("dettaglio.jsp");

		rd.forward(request, response);

	}

}
