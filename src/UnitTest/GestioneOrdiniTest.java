package UnitTest;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Beans.Ordine;
import Beans.Utente;
import Database.Database;
import Database.DatabaseQuery;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GestioneOrdiniTest {

	//Dichiarazione delle variabili di istanza che permettono di controllare se il valore è presente all'interno del sistema
	private static final String email= "pasquale@Montino.com";
	private static final String nome= "Pasquale";
	private static final String cognome= "Montino";
	private static final String password= "Andrea85";
	private static final String conferma_password= "Andrea85";
	private static final String sesso= "u";


	private static Utente utente;


	private static final int id_ordine = 5;
	private static final int id_prodotto = 10;
	//private static final String email = "francesco@garofalo.com";
	private static final Date data = new Date(20, 12, 2018);
	private static final String pagamento = "postepay";
	private static final String indirizzo = "Via Avellino, 56";
	private static final String note = "Sono nato a Napoli, quindi sono di Napoli";
	private static final BigDecimal prezzo = new BigDecimal(30);

	Ordine ordine= new Ordine (id_ordine, id_prodotto, email, data, pagamento, indirizzo, note, prezzo);

	/*
	 * Metodo che permette di testare sia l'aggiunta di un ordine da parte di un utente, sia il get degli ordini dell'utente stesso
	 */
	@Test
	public void check1_AddOrdine() throws SQLException {
		boolean check = false;
		utente= new Utente(email, nome, cognome, password, sesso, "foto");
		DatabaseQuery.addUser(utente);
		DatabaseQuery.addOrdine(ordine);
		ArrayList<Ordine> ritorna_ordini= DatabaseQuery.getOrdiniUtente(email);
		System.out.println(ritorna_ordini);
		for (Ordine o: ritorna_ordini) {
			if (o.getIdOrdine() == id_ordine) {
				check = true;
			}
		}
		assertEquals(check, true);
	}

	/*
	 * Metodo che permette di eliminare un determinato ordine dal DataBase
	 */
	@Test
	public void check2_EliminaOrdine() throws SQLException {

		ArrayList<Ordine> ordini = DatabaseQuery.getOrdiniUtente(email);
		int num_ordini= ordini.size();
		System.out.println("Numero di ordini prima: " + num_ordini);

		Connection connection = null;
		PreparedStatement psAddOrdine = null;

		try{
			connection = Database.getConnection();
			psAddOrdine = connection.prepareStatement("DELETE FROM commerce1.ordine WHERE idOrdine = 5");

			psAddOrdine.executeUpdate();

			connection.commit();
			System.out.println("Insert Ordine Connessione...");
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}

		ArrayList<Ordine> ordini_succ = DatabaseQuery.getOrdiniUtente(email);
		int num_ordini1= ordini_succ.size();
		num_ordini1++;

		assertEquals(num_ordini, num_ordini1);
		DatabaseQuery.delUser(email);
	}
}