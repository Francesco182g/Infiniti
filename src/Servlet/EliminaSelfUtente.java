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
import javax.servlet.http.HttpSession;

import Beans.Prodotto;
import Beans.Utente;
import Database.DatabaseQuery;

/**
 * @author Francesco Garofalo
 * Servlet implementation class EliminaSelfUtente
 */
@WebServlet("/EliminaSelfUtente")
public class EliminaSelfUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaSelfUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("user");
		String email = u.getEmail();
        session.invalidate();
        
        try {
			DatabaseQuery.delUser(email);
			System.out.println("Servlet: Elimino account " +email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Del non riuscita");
			e.printStackTrace();
		}
        
		try {
			DatabaseQuery.delCarrello(email);
			System.out.println("Servlet: Pulisco il carrello dell'user: "+email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<Prodotto> prodotti = new ArrayList<>();
			DatabaseQuery.getProdottiUtente(email);
			
			for (Prodotto p: prodotti) {
				p.setQuantità(0);
				DatabaseQuery.modifica_Prodotto(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
