package Beans;

import java.math.BigDecimal;
import java.sql.Date;

public class Ordine {
	private int idOrdine;
	private int idProdotto;
	private String idUtente;
	private Date data;
	private String pagamento;
	private String indirizzo;
	private String note;
	private BigDecimal prezzo;
	
	public Ordine(){}
	
	public Ordine(int idOrdine, int idProdotto, String idUtente, Date data, String pagamento, String indirizzo, String note, BigDecimal prezzo) {
		super();
		this.idOrdine = idOrdine;
		this.idProdotto = idProdotto;
		this.idUtente = idUtente;
		this.data = data;
		this.pagamento = pagamento;
		this.indirizzo = indirizzo;
		this.note = note;
		this.prezzo = prezzo;
	}

	public int getIdOrdine(){
		return idOrdine;
	}
	
	public void setIdOrdine(int idOrdine){
		this.idOrdine = idOrdine;
	}
	
	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public BigDecimal getPrezzo(){
		return prezzo;
	}
	
	public void setPrezzo(BigDecimal prezzo){
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", idProdotto=" + idProdotto + ", idUtente=" + idUtente + ", data="
				+ data + ", pagamento=" + pagamento + ", indirizzo=" + indirizzo + ", note=" + note + ", prezzo="
				+ prezzo + "]";
	}

}
