package Model;

public class Client {
    
	private String name;
	private String cin;
	private int phone;
	private String email;
	private String password;
	
	
	public Client(String name, String cin, int phone, String email, String password) {
		super();
		this.name = name;
		this.cin = cin;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}


	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
