package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Prodotto;
import Beans.Utente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class GetListaUtenti
 */
@WebServlet("/GetListaUtenti")
public class GetListaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListaUtenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Utente> lista = new ArrayList<>();
		
try {
			
			lista=DatabaseQuery.getUtentiAll();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("AdminUtenti.jsp").forward(request, response);
			
			if(lista.toString() == "[]"){
				request.setAttribute("vis", "nulla");
			} else{
				request.setAttribute("vis", "visible");
			}
			
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
