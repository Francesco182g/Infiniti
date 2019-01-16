package UnitTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Beans.Carrello;
import Beans.Prodotto;
import Beans.Utente;
import Database.DatabaseQuery;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GestioneCarrelloTest {

	//Dichiarazione delle variabili di istanza che permettono di controllare se il valore è presente all'interno del sistema
	private static final String email= "Francesco@Garofalo.com";
	private static final String nome= "Giovanni";
	private static final String cognome= "Dario";
	private static final String password= "Andrea85";
	private static final String conferma_password= "Andrea85";
	private static final String sesso= "u";
	private static Utente utente;

	private static final int id_Carrello = 1;
	private static final int id_Prodotto = 5;

	/*
	 * Metodo che permette di testare sia l'aggiunta che il ritorno di un prodotto da un determinato carrello
	 */
	@Test
	public void check1_AddCarrello() throws SQLException {
		boolean check = false;
		utente= new Utente(email, nome, cognome, password, sesso, "foto");
		DatabaseQuery.addUser(utente);
		DatabaseQuery.addCarrello(id_Prodotto, email);
		ArrayList<Carrello> prodotti = DatabaseQuery.getCarrello(email);
		for (Carrello c: prodotti) {
			if (c.getIdProdotto() == id_Prodotto) {
				check = true;
			}
		}
		assertEquals(true, check);
	}

	/*
	 * Metodo che permette di testare l'eliminazione di un prodotto da un determinato carrello
	 */
	@Test
	public void check2_DeleteCarrelloProdotto () throws SQLException {
		boolean check = true;
		System.out.println("Eccomi");
		DatabaseQuery.delProdottoCarrello(id_Prodotto);
		System.out.println("Mi trovo qui");
		ArrayList<Carrello> prodotti = DatabaseQuery.getCarrello(email);
		System.out.println("Stampo i valori di ritorno" + prodotti);
		for (Carrello p: prodotti) {
			if (p.getIdProdotto() == id_Prodotto) {
				check = false;
			}
		}
		assertEquals(true, check);
	}

	@Test
	public void check3_CancelloCarrello () throws SQLException {

		DatabaseQuery.delUser(email);

		DatabaseQuery.delCarrello(email);

		ArrayList<Carrello> carrelli = DatabaseQuery.getCarrello(email);

		assertEquals(carrelli.size(), 0);

	}
}