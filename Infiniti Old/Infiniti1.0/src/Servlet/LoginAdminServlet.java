package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Admin;
import Database.DatabaseQuery;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
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
		
			Admin a = DatabaseQuery.getAdmin(Email);
			System.out.println("Stampa " +a);
			if(a!=null)
			{
				System.out.println("Primo if");
				if(a.getPassword().toString().equals(Password))
				{
					
						System.out.println("Password: " + a.getPassword().toString());
						System.out.println("Pass Insert: " +Password);
						
						HttpSession session = request.getSession();
						session.setAttribute("admin", a);
						request.getRequestDispatcher("AdminProdotto.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
