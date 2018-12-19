package UnitTest;

import Beans.Utente;
import Database.DatabaseQuery;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class GestioneUtenteTest {

	//Dichiarazione delle variabili di istanza che permettono di controllare se il valore è presente all'interno del sistema
	private static final String email= "Francesco@Garofalo.com";
	private static final String nome= "Francesco";
	private static final String cognome= "Garofalo";
	private static final String password= "Andrea85";
	private static final String conferma_password= "Andrea85";
	private static final String sesso= "u";
	
	private static Utente utente;
	
	public GestioneUtenteTest() {
		utente= new Utente(email, nome, cognome, password, conferma_password, sesso);
	}
	
	//Testo il metodo della registrazione
	@Test
	public void check_Registrazione() throws SQLException {
		DatabaseQuery.addUser(utente);
		Utente u = DatabaseQuery.getUtenteByID(email);
		System.out.println(u.toString());
		assertEquals(u, utente);
	}
	
	
	//Metodo che successivamente va a testare la login
	@Test
	public void check_Login() throws SQLException {
		Utente u = DatabaseQuery.getUtenteByID(email);
		assertEquals(utente, u);
	}
	
	//Metodo che permette di testare la logout
	@Test
	public void check_Delete() throws SQLException {
		DatabaseQuery.delUser(email);
		Utente u = DatabaseQuery.getUtenteByID(email);
		assertEquals(u, null);
	}
}