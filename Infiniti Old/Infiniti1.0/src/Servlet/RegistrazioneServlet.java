package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utente;
import Database.DatabaseQuery;


/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Email = request.getParameter("user_email");
		System.out.println(Email);


		
		String Nome = request.getParameter("user_nome"); 
		System.out.print(Nome);

		
		String Cognome = request.getParameter("user_cognome");

		
		
		String Password = request.getParameter("user_password");
		
		String confPassword = request.getParameter("user_confpassword");

		System.out.println(confPassword);
		
		//Controlla che Password e confPassword siano uguali

		
		String Sesso = request.getParameter("user_sesso");
		
		//Non attivo
		String Foto = "non attivo";
		
		
		Utente u = new Utente(Email, Nome, Cognome, Password, Sesso, Foto);
		System.out.println(u);
		
		try {
			DatabaseQuery.addUser(u);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("errorlog.jsp").forward(request, response);
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
