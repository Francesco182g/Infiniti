package Servlet;

import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Prodotto;
import Database.DatabaseQuery;

public class VisualizzaOfferte {
	
	public static ArrayList<Prodotto> printOfferte() throws SQLException {
		ArrayList<Prodotto> offerte = new ArrayList<>();
		offerte = DatabaseQuery.cerca_Offerte();
		return offerte;
		
	}

	public VisualizzaOfferte() {
		super();
		// TODO Auto-generated constructor stub
	}
}
