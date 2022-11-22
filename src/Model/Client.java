package Model;

public class Client {
    protected int id_sign;
	protected String CIN;
	protected String prenom;
	protected String nom;
	protected int Tele;
	protected String Email;
	
	
	public Client() {
		
	}
	public Client(int id_sign) {
		
		this.id_sign = id_sign;
		
	}
	
	
	public Client(int id_sign, String cIN, String prenom, String nom, int tele, String email) {
		
		this.id_sign = id_sign;
		CIN = cIN;
		this.prenom = prenom;
		this.nom = nom;
		Tele = tele;
		Email = email;
	}
	
	public Client(String cIN, String prenom, String nom, int tele, String email) {
		
		CIN = cIN;
		this.prenom = prenom;
		this.nom = nom;
		Tele = tele;
		Email = email;
	}
	
	public int getId_sign() {
		return id_sign;
	}
	public void setId_sign(int id_sign) {
		this.id_sign = id_sign;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getTele() {
		return Tele;
	}
	public void setTele(int tele) {
		Tele = tele;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
