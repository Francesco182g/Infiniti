package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Prodotto;
import Beans.Utente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class AddCarrelloServlet
 */
@WebServlet("/AddCarrelloServlet")
public class AddCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCarrelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("user");


		String user = u.getEmail();

		String Prodotto = request.getParameter("prodott");
		System.out.println(Prodotto);

		if(Prodotto == null){
			System.out.println("Servlet: Valore null ricevuto dalla jsp");
		} else {
			System.out.println("Servlet: ricevuta richiesta inserimento");
			int idProdotto = Integer.parseInt(Prodotto);
			
			try {
				Prodotto p = DatabaseQuery.getProdotto(idProdotto);
				if(p.getUtente() == user) {
					request.getRequestDispatcher("CarrelloLog.jsp").forward(request, response);
				}
				
				DatabaseQuery.addCarrello(idProdotto, user);
				System.out.println("Servlet: Aggiungo al carrello " +user+ " id: " +idProdotto);
				int c = DatabaseQuery.getCountCarrello(user);
				session.setAttribute("carrello", c);
				request.getRequestDispatcher("CarrelloLog.jsp").forward(request, response);
			} catch (SQLException e) {
				System.out.println("Impossibile aggiungere al carrello...");
				e.printStackTrace();
				request.getRequestDispatcher("CarrelloLog.jsp").forward(request, response);

			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
