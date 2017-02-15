package Servlet;

import java.io.IOException;
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
 * Servlet implementation class GetListaProdottiUtente
 */
@WebServlet("/GetListaProdottiUtente")
public class GetListaProdottiUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListaProdottiUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Prodotto> lista = new ArrayList<>();
		
		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("user");
		String email = u.getEmail();
		try {	
			
			lista=DatabaseQuery.getProdottiUtente(email);
			request.setAttribute("lista", lista);
			
			if(lista.toString() == "[]"){
				request.setAttribute("vis", "nulla");
			} else{
				request.setAttribute("vis", "visible");
			}
			request.getRequestDispatcher("MieiProdotti.jsp").forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
