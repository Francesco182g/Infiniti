package Database;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Admin;
import Beans.Carrello;
import Beans.Ordine;
import Beans.Prodotto;
import Beans.Utente;

public class TestDatabase {

	public static void main(String[] args) throws SQLException {
		/*
		String email = "francesco182@hotmail.it";
		String nome = "Francesco";
		String cognome = "Garofalo";
		String password = "password";
		String sesso = "M";
		
		Utente utente = new Utente(email, nome, cognome, password, sesso);

		
		Utente u = DatabaseQuery.getUtenteByID("francescogarofalo@studenti.unisa.it");
		System.out.println(u.getPassword());
		*/

		
		
		//ArrayList<Prodotto> lista = new ArrayList<>();
		
		//lista=DatabaseQuery.cercaProdotti("Essenza");
		
		//System.out.println(lista);
		
/*		
		Utente u = DatabaseQuery.getUtenteByID(email);
		System.out.println(u);
		*/
		//Prodotto p = new Prodotto (Prodotto, descrizione, quantità, 2.00 , tipo, condizione, nome, "PATH");
		//DatabaseQuery.delProdotto(Prodotto);
		//System.out.println("Stampo prodotto: "+p);
		
		/*
		
		int id = 15;
		Prodotto p = new Prodotto();
		p = DatabaseQuery.getProdotto(id);
		System.out.println(p);
		
		String email = "francescogarofalo@studenti.unisa.it";
		ArrayList<Carrello> lista = new ArrayList<>();
		lista =	DatabaseQuery.getCarrello(email);	
		System.out.println(lista);	
		
		ArrayList<Prodotto> prod = new ArrayList<>();
		
		for(int i = 0; i<lista.size(); i++){
			Prodotto p = DatabaseQuery.getProdotto(lista.get(i).getIdProdotto());
			prod.add(p);
		}
		System.out.println(prod);
	
		Date data = new Date(23, 11, 1200);
		BigDecimal prezzo = new BigDecimal(30);
		Ordine ordine = new Ordine(2, 2, "Ciao", data ,"pagamento", "String indirizzo", "String note", prezzo);
		DatabaseQuery.addOrdine(ordine);
	
		String email = "francescogarofalo@studenti.unisa.it";
		int i = DatabaseQuery.getCountCarrello(email);
		System.out.println(i);
	*/
		//String a = "admin@admin.it";
		//String p = "man";
		//Admin admin = DatabaseQuery.getAdmin(a);
		//System.out.println(admin);
		
		//ArrayList prod = DatabaseQuery.getUtentiAll();
		//System.out.println(prod);
	}
}
