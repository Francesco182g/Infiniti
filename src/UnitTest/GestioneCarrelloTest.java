package UnitTest;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
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
	private static final String email1= "Antonio@Fasulo.com";
	private static final String nome= "Giovanni";
	private static final String cognome= "Dario";
	private static final String password= "Andrea85";
	private static final String conferma_password= "Andrea85";
	private static final String sesso= "u";
	private static Utente utente;
	private static Utente utente1;

	private static final int id_Carrello = 1;

	//Variabili di istanza per un determinato prodotto
	private static final int id_prodotto = 80;
	private static final String descrizione = "Prodotto usato per il test";
	private static final int quantità= 3;
	BigDecimal prezzo = new BigDecimal(30.00);
	private static final String tipo = "test tipo";
	private static final String condizione = "usato";
	private static final String nomeProd = "Tazza Napoli";
	private static final String path= "test path";
	//private static final String email= "andrea@bocelli.it";
	private static final int offerta= 20;
	private static Prodotto p = new Prodotto();

	/*
	 * Metodo che permette di testare sia l'aggiunta che il ritorno di un prodotto da un determinato carrello
	 */
	@Test
	public void check1_AddCarrello() throws SQLException {
		boolean check = false;
		//Inserisco l'utente fittizio
		utente= new Utente(email, nome, cognome, password, sesso, "foto");
		utente1= new Utente(email1, nome, cognome, password, sesso, "foto");
		DatabaseQuery.addUser(utente);
		DatabaseQuery.addUser(utente1);
		//Inserisco il prodotto
		p.setIdProdotto(id_prodotto);
		p.setDescrizione(descrizione);
		p.setQuantità(quantità);
		p.setPrezzo(prezzo);
		p.setTipo(tipo);
		p.setCondizione(condizione);
		p.setNome(nomeProd);
		p.setPath(path);
		p.setIdUtente(email);
		p.setOfferta(offerta);
		
		DatabaseQuery.addProdotto(p, email);
		
		DatabaseQuery.addCarrello(p.getIdProdotto(), email1);
		
		ArrayList<Carrello> prodotti = DatabaseQuery.getCarrello(email1);
		for (Carrello c: prodotti) {
			if (c.getIdProdotto() == p.getIdProdotto()) {
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
		DatabaseQuery.delProdottoCarrello(p.getIdProdotto());
		System.out.println("Mi trovo qui");
		ArrayList<Carrello> prodotti = DatabaseQuery.getCarrello(email1);
		System.out.println("Stampo i valori di ritorno" + prodotti);
		for (Carrello p: prodotti) {
			if (p.getIdProdotto() == p.getIdProdotto()) {
				check = false;
			}
		}
		assertEquals(true, check);
	}

	@Test
	public void check3_CancelloCarrello () throws SQLException {

		DatabaseQuery.delUser(email1);
		DatabaseQuery.delUser(email);
		DatabaseQuery.delProdotto(p.getIdProdotto());

		DatabaseQuery.delCarrello(email1);

		ArrayList<Carrello> carrelli = DatabaseQuery.getCarrello(email1);

		assertEquals(carrelli.size(), 0);

	}
}