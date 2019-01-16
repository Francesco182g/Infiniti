package Beans;

public class Utente {
	
	private String email;
	private String Nome;
	private String Cognome;
	private String Password;
	private String Sesso;
	private String Foto;

	public Utente () {}
	
	public Utente(String mail, String nome, String cognome, String pass, String sesso, String foto) {
		super();
		this.email = mail;
		this.Nome = nome;
		this.Cognome = cognome;
		this.Password = pass;
		this.Sesso = sesso;
		this.Foto = foto;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (Cognome == null) {
			if (other.Cognome != null)
				return false;
		} else if (!Cognome.equals(other.Cognome))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Sesso == null) {
			if (other.Sesso != null)
				return false;
		} else if (!Sesso.equals(other.Sesso))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utente [email=" + email + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Password=" + Password
				+ ", Sesso=" + Sesso + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getSesso() {
		return Sesso;
	}

	public void setSesso(String sesso) {
		Sesso = sesso;
	}
	
	public String getFoto(){
		return Foto;
	}
	
	public void setFoto(String foto){
		this.Foto = foto;
	}
	
}