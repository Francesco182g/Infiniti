package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
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
 * Servlet implementation class EliminaProdottoServlet
 */
@WebServlet("/EliminaProdottoServlet")
public class EliminaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaProdottoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Prodotto = request.getParameter("prodotto_id");
		System.out.println(Prodotto);

		if(Prodotto == null){
			System.out.println("Servlet: Valore null ricevuto dalla jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			System.out.println("Servlet: ricevuta richiesta modifica");
			int idProdotto = Integer.parseInt(Prodotto);
			
			try {
				DatabaseQuery.delProdotto(idProdotto);
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
