package UnitTest;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import Beans.Carrello;
import Beans.Utente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GestioneCarrelloTest {

	//Dichiarazione delle variabili di istanza che permettono di controllare se il valore è presente all'interno del sistema
	private static final String email= "Francesco@Garofalo.com";
	private static final String nome= "Giovanni";
	private static final String cognome= "Dario";
	private static final String password= "Andrea85";
	private static final String conferma_password= "Andrea85";
	private static final String sesso= "u";
	
	private static final int id_Carrello = 1;
	
	private static Utente utente;
	private static Carrello carrello;
	
	

}