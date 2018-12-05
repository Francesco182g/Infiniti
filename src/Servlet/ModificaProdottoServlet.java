package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Prodotto;
import Database.DatabaseQuery;

/**
 * Servlet implementation class EliminaProdottoServlet
 */
@WebServlet("/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaProdottoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Prodotto = request.getParameter("prodott");
		System.out.println(Prodotto);

		if(Prodotto == null){
			System.out.println("Servlet: Valore null ricevuto dalla jsp");
		} else {
			System.out.println("Servlet: ricevuta richiesta modifica");
			int idProdotto = Integer.parseInt(Prodotto);
			
			try {
				Prodotto prod = DatabaseQuery.getProdotto(idProdotto);
				request.setAttribute("prodotto", prod);
				request.getRequestDispatcher("Profilo.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
