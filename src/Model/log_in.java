package Model;

public class log_in {
    protected int id_log;
    protected String CIN;
    protected String password;
    
	public log_in() {
		super();
	}

	public log_in(int id_log, String cIN, String password) {
		super();
		this.id_log = id_log;
		CIN = cIN;
		this.password = password;
	}

	public log_in(String cIN, String password) {
		super();
		CIN = cIN;
		this.password = password;
	}

	public int getId_log() {
		return id_log;
	}

	public void setId_log(int id_log) {
		this.id_log = id_log;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInt(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	
    
    
}
