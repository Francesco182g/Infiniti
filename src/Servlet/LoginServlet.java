package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Carrello;
import Beans.Utente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class LoginServlet
 * @param <Utente>
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Email = request.getParameter("user_email"); 
		System.out.print(Email);
		
		String Password = request.getParameter("user_password");
		System.out.println(Password);
		
		try {
		
			Utente u = DatabaseQuery.getUtenteByID(Email);
			System.out.println("Stampa " +u);
			if(u!=null)
			{
				System.out.println("Primo if");
				if(u.getPassword().toString().equals(Password))
				{
					
						System.out.println("Password: " + u.getPassword().toString());
						System.out.println("Pass Insert: " +Password);
						
						HttpSession session = request.getSession();
						session.setAttribute("user", u);
					int c = DatabaseQuery.getCountCarrello(Email);
						session.setAttribute("carrello", c);
						request.getRequestDispatcher("Indexlog.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("errorlog.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("errorlog.jsp").forward(request, response);
			}	
			} catch (SQLException e) {
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
