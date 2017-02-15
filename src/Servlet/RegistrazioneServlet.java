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
		System.out.println(Cognome);
		
		String Password = request.getParameter("user_password");
		System.out.println(Password);
		
		String confPassword = request.getParameter("user_confpassword");
		System.out.println(confPassword);
		
		String Sesso = request.getParameter("user_sesso");
		System.out.println(Sesso);
		
		String Foto = request.getParameter("user_foto");
		System.out.println(Foto);
		
		
		Utente u = new Utente(Email, Nome, Cognome, Password, Sesso, Foto);
		System.out.println(u);
		
		try {
			DatabaseQuery.addUser(u);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
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
