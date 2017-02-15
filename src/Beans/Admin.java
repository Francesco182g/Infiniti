package Beans;

public class Admin {
	private String userName;
	private String password;
	private int attivo;
	
	public Admin() {}
	
	public Admin(String userName, String password, int attivo) {
		super();
		this.userName = userName;
		this.password = password;
		this.attivo = attivo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int isAttivo() {
		return attivo;
	}
	public void setAttivo(int attivo) {
		this.attivo = attivo;
	}
	
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + ", attivo=" + attivo + "]";
	}
	

}

