package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Prodotto;
import Database.DatabaseQuery;

/**
 * Servlet implementation class EliminaUtenteServlet
 */
@WebServlet("/EliminaUtenteServlet")
public class EliminaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Utente = request.getParameter("prodott");

			
			try {
				DatabaseQuery.delUser(Utente);
				request.getRequestDispatcher("AdminUtenti.jsp").forward(request, response);
			} catch (SQLException e) {
				System.out.println("Impossibile del utente.");
				e.printStackTrace();
			}
			
			try {
				DatabaseQuery.delCarrello(Utente);
				System.out.println("Servlet: Pulisco il carrello dell'user: "+ Utente);
				int c = DatabaseQuery.getCountCarrello(Utente);
				//session.setAttribute("carrello", c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				ArrayList<Prodotto> prodotti = new ArrayList<>();
				DatabaseQuery.getProdottiUtente(Utente);
				
				for (Prodotto p: prodotti) {
					p.setQuantità(0);
					DatabaseQuery.modifica_Prodotto(p);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
