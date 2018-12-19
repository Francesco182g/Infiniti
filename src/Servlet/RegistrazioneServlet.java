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
		if(Email.length() < 5 | Email.length() > 45) {
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
		}


		String Nome = request.getParameter("user_nome"); 
		System.out.print(Nome);
		if(Nome.length() < 1 | Nome.length() > 45) {
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
		}

		String Cognome = request.getParameter("user_cognome");
		if(Cognome.length() < 1 | Cognome.length() > 45) {
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
		}


		String Password = request.getParameter("user_password");
		if(Password.length() < 5 | Password.length() > 8) {
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
		}

		String confPassword = request.getParameter("user_confpassword");
		if(confPassword.length() < 5 | confPassword.length() > 8) {
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
		}
		System.out.println(confPassword);

		//Controlla che Password e confPassword siano uguali
		if(Password!=confPassword) {
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
		}

		String Sesso = request.getParameter("user_sesso");


		String Foto = "Distattivato";


		Utente u = new Utente(Email, Nome, Cognome, Password, Sesso, Foto);
		System.out.println(u);

		try {
			DatabaseQuery.addUser(u);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("Login.jsp").forward(request, response);
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
