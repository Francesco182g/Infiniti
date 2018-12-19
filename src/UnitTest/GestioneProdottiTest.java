package UnitTest;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.mysql.fabric.xmlrpc.base.Data;

import static org.junit.Assert.*;
import Beans.Prodotto;
import Database.DatabaseQuery;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GestioneProdottiTest {

	//Variabili di istanza per un determinato prodotto
	private static final int id_prodotto = 80;
	private static final String descrizione = "Prodotto usato per il test";
	private static final int quantità= 3;
	BigDecimal prezzo = new BigDecimal(30.00);
	private static final String tipo = "test tipo";
	private static final String condizione = "usato";
	private static final String nome = "Tazza Napoli";
	private static final String path= "test path";
	private static final String email= "andrea@bocelli.it";
	private static final int offerta= 20;
	private static Prodotto p = new Prodotto();

	private int size_prodotti= 0;

	//Test del metodo che permette di aggiungere un determinato prodotto
	@Test
	public void check1_AddProdotto() throws SQLException { 
		p.setIdProdotto(id_prodotto);
		p.setDescrizione(descrizione);
		p.setQuantità(quantità);
		p.setPrezzo(prezzo);
		p.setTipo(tipo);
		p.setCondizione(condizione);
		p.setNome(nome);
		p.setPath(path);
		p.setIdUtente(email);
		p.setOfferta(offerta);
		DatabaseQuery.addProdotto(p, email);
		Prodotto risultato= DatabaseQuery.getProdotto(id_prodotto);
		risultato.setPrezzo(prezzo);
		p.setPrezzo(prezzo);
		assertEquals(p.toString(), risultato.toString());
	}

	//Test del metodo che permette di ricercare un prodotto
	@Test
	public void check2_RicercaProdotto() throws SQLException {
		ArrayList<Prodotto> prodotti = DatabaseQuery.cercaProdotti(nome);
		assertEquals(prodotti.get(0).getNome(), nome);
	}

	//Test che effettua il controllo del prodotto By_Id
	@Test
	public void check3_Prodotto_By_Id() throws SQLException {
		Prodotto p = DatabaseQuery.getProdotto(id_prodotto);
		assertEquals(p.getIdProdotto(), id_prodotto);
	}

	//Test che permette di ritornare i prodotti di un determinato utente
	@Test
	public void check4_RicercaByUtente() throws SQLException {
		ArrayList<Prodotto> prodotti= DatabaseQuery.getProdottiUtente(email);
		boolean check= true;
		for (Prodotto p: prodotti) {
			if (p.getUtente().equals(email)) {
				//Corretto
			}else {
				check= false;
			}
		}
		assertEquals(true, check);
	}

	//Test che controlla il get di tutti i prodotti resenti all'interno del DB
	@Test
	public void check6_getProdotti() throws SQLException {
		ArrayList<Prodotto> prodotti = DatabaseQuery.getProdotti();
		int precedente = prodotti.size();
		assertEquals(prodotti.size(), 4);
	}

	//Test che ritorna i prodotti in offerta
	@Test
	public void check7_GetOfferte() throws SQLException {
		ArrayList<Prodotto> prodotti = DatabaseQuery.cerca_Offerte();
		int prodotti_offerte = prodotti.size();
		ArrayList<Prodotto> prodotti1= DatabaseQuery.getProdotti();
		int count = 0;
		for (Prodotto p: prodotti1) {
			if (p.getOfferta()>0) {
				count++;
			}
		}
		assertEquals(prodotti_offerte, count);
	}
	
	//Test che permette di modificare un determinato prodotto
	@Test
	public void check8_ModifyProduct() throws SQLException {
		int offerta_nuova= 35;
		p.setOfferta(offerta_nuova);
		DatabaseQuery.modifica_Prodotto(p);
		Prodotto p = DatabaseQuery.getProdotto(id_prodotto);
		assertEquals(offerta_nuova, p.getOfferta());
	}

	//Test del metodo che permette di eliminare un prodotto
	@Test
	public void check9_DeleteProdotto() throws SQLException {
		DatabaseQuery.delProdotto(id_prodotto);
		Prodotto p= DatabaseQuery.getProdotto(id_prodotto);
		assertEquals(p, null);
	}
}