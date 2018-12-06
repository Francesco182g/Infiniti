package Servlet;

import java.awt.Checkbox;
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
 * Servlet implementation class CercaProdottiServet
 */
@WebServlet("/CercaProdottiServlet")
public class CercaProdottiServlet extends HttpServlet {
	static ArrayList<Prodotto>listProdotti;
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaProdottiServlet() {
        super();
        listProdotti = new ArrayList<Prodotto>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente utente = (Utente)session.getAttribute("user");
		
		String nomeProdotto = request.getParameter("nomeProdotto"); 
		
		try{
			//System.out.println("NomeProdotto:" +nomeProdotto);
			listProdotti = DatabaseQuery.cercaProdotti(nomeProdotto);
			//System.out.println(listProdotti.toString());
			request.setAttribute("listaProdotti", listProdotti);
			
			
			
			if(listProdotti.toString() == "[]"){
				request.setAttribute("vis", "nulla");
			} else{
				request.setAttribute("vis", "visible");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(utente != null){
			request.getRequestDispatcher("ProdottiLog.jsp").forward(request, response);		
		} else {
			request.getRequestDispatcher("Prodotti.jsp").forward(request, response);
		}

		return;
}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
