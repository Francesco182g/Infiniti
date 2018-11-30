package Beans;

public class Carrello {
	private String idUtente;
	private int idProdotto;

	public Carrello(){}

	public Carrello(String idUtente, int idProdotto) {
		super();
		this.idUtente = idUtente;
		this.idProdotto = idProdotto;
	}
	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	@Override
	public String toString() {
		return "Carrello [idUtente=" + idUtente + ", idProdotto=" + idProdotto + "]";
	}
	
}
