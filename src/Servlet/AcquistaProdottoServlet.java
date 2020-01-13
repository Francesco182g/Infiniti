package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Carrello;
import Beans.Ordine;
import Beans.Prodotto;
import Beans.Utente;
import Database.DatabaseQuery;

/**
 * Author FG
 * Servlet implementation class AcquistaProdottoServlet
 */

@WebServlet("/AcquistaProdottoServlet")
public class AcquistaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcquistaProdottoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("user");

		String email =  u.getEmail();

		
		String Pagamento = request.getParameter("pagamento");
		if(Pagamento.length() < 5 | Pagamento.length() > 45) {
			request.getRequestDispatcher("CarrelloLog.jsp").forward(request, response);
		}
		System.out.println(Pagamento);

		String Indirizzo = request.getParameter("indirizzo"); 
		if(Indirizzo.length() < 5 | Indirizzo.length() > 50) {
			request.getRequestDispatcher("CarrelloLog.jsp").forward(request, response);
		}
		System.out.print(Indirizzo);

		
		String Descrizione = request.getParameter("descrizione");
		if(Descrizione.length() < 5 | Descrizione.length() > 100) {
			request.getRequestDispatcher("CarrelloLog.jsp").forward(request, response);
		}
		System.out.println(Descrizione);

		LocalDate localDate = LocalDate.now();
		int day = localDate.getDayOfMonth();
		int mese = localDate.getMonthValue();
		int year = localDate.getYear();
		@SuppressWarnings("deprecation")
		Date data = new Date(year, mese, day);

		ArrayList<Carrello> lista = new ArrayList<>();
		try {
			lista = DatabaseQuery.getCarrello(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(lista);
		for (int i = 0; i < lista.size(); i++) {
			try {
				Prodotto p = DatabaseQuery.getProdotto(lista.get(i).getIdProdotto());
				p.setQuantità(p.getQuantità() - 1);
				DatabaseQuery.modifica_Prodotto(p);
				//modifica prezzo offerta
				if(p.getOfferta()==0) {
					Ordine o = new Ordine(0, p.getIdProdotto(), email, data, Pagamento, Indirizzo, Descrizione,  p.getPrezzo());
					System.out.println(o);
					DatabaseQuery.addOrdine(o);
					p=null;
					o=null;
				} else {
					BigDecimal offerta = BigDecimal.valueOf(p.getOfferta());
					BigDecimal prezzoNuovo= p.getPrezzo().multiply(offerta);
					prezzoNuovo = prezzoNuovo.divide(BigDecimal.valueOf(100));
					prezzoNuovo = p.getPrezzo().subtract(prezzoNuovo);
					Ordine o = new Ordine(0, p.getIdProdotto(), email, data, Pagamento, Indirizzo, Descrizione,  prezzoNuovo);
					System.out.println(o);
					DatabaseQuery.addOrdine(o);
					p=null;
					o=null;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			try {
				DatabaseQuery.delCarrello(email);
				request.getRequestDispatcher("Indexlog.jsp").forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ERRORE INSERIMENTO (Ordine giï¿½ presente)");
				request.getRequestDispatcher("Indexlog.jsp").forward(request, response);

			}
		}		

		request.getRequestDispatcher("MieiOrdini.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
