package Model;

public class destination {
	   protected int id_destination ;
		protected String name_of_company;
		protected String Ville_depart;
		protected String Ville_darriver;
		protected int Date_journy;
		protected int Num_of_Ticket;
		
		
	public destination(int id_destination) {
		
			this.id_destination = id_destination;
		}
		public destination() {
			
		}
		public destination(String name_of_company, String ville_depart, String ville_darriver, int date_journy,
				int num_of_Ticket) {
			super();
			this.name_of_company = name_of_company;
			Ville_depart = ville_depart;
			Ville_darriver = ville_darriver;
			Date_journy = date_journy;
			Num_of_Ticket = num_of_Ticket;
		}
		public destination(int id_destination, String name_of_company, String ville_depart, String ville_darriver,
				int date_journy, int num_of_Ticket) {
			super();
			this.id_destination = id_destination;
			this.name_of_company = name_of_company;
			Ville_depart = ville_depart;
			Ville_darriver = ville_darriver;
			Date_journy = date_journy;
			Num_of_Ticket = num_of_Ticket;
		}
		public int getId_destination() {
			return id_destination;
		}
		public void setId_destination(int id_destination) {
			this.id_destination = id_destination;
		}
		public String getName_of_company() {
			return name_of_company;
		}
		public void setName_of_company(String name_of_company) {
			this.name_of_company = name_of_company;
		}
		public String getVille_depart() {
			return Ville_depart;
		}
		public void setVille_depart(String ville_depart) {
			Ville_depart = ville_depart;
		}
		public String getVille_darriver() {
			return Ville_darriver;
		}
		public void setVille_darriver(String ville_darriver) {
			Ville_darriver = ville_darriver;
		}
		public int getDate_journy() {
			return Date_journy;
		}
		public void setDate_journy(int date_journy) {
			Date_journy = date_journy;
		}
		public int getNum_of_Ticket() {
			return Num_of_Ticket;
		}
		public void setNum_of_Ticket(int num_of_Ticket) {
			Num_of_Ticket = num_of_Ticket;
		}
		
		
		
		
		
		
		
		
		}
