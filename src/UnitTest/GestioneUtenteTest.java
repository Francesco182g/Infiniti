package UnitTest;

import Beans.Utente;
import Database.DatabaseQuery;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestioneUtenteTest {
  
  //Dichiarazione delle variabili di istanza che permettono di controllare se il valore è presente all'interno del sistema
  private static final String email= "Francesco@Garofalo.com";
  private static final String nome= "Giovanni";
  private static final String cognome= "Dario";
  private static final String password= "Andrea85";
  private static final String conferma_password= "Andrea85";
  private static final String sesso= "u";
    
  private static Utente utente;
  //Testo il metodo della registrazione
  @Test
  public void check1_Registrazione() throws SQLException {
    utente= new Utente(email, nome, cognome, password, sesso, "foto");
    DatabaseQuery.addUser(utente);
    Utente u = DatabaseQuery.getUtenteByID(email);
    System.out.println(u.toString());
    assertEquals(u, utente);
    //Ciaoo
  }
  
  
  //Metodo che successivamente va a testare la login
  @Test
  public void check2_Login() throws SQLException {
    Utente u = DatabaseQuery.getUtenteByID(email);
    assertEquals(utente, u);
  }
  
  //Metodo che permette di testare la logout
  @Test
  public void check4_Delete() throws SQLException {
    DatabaseQuery.delUser(email);
    Utente u = DatabaseQuery.getUtenteByID(email);
    assertEquals(u, null);
  }

}