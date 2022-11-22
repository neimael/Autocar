package Model;

public class TicketLost {
	   protected int id_TicketLost;
		protected String CIN;
		
		
		
		
		
		
		public TicketLost() {
			
		}
		public TicketLost(int id_TicketLost) {
			
			this.id_TicketLost = id_TicketLost;
		}
		public TicketLost(int id_TicketLost, String cIN) {
			
			this.id_TicketLost = id_TicketLost;
			CIN = cIN;
		}
		
		public int getId_TicketLost() {
			return id_TicketLost;
		}
		
		public void setId_TicketLost(int id_TicketLost) {
			this.id_TicketLost = id_TicketLost;
		}
		
		public String getCIN() {
			return CIN;
		}
		
		public void setCIN(String cIN) {
			CIN = cIN;
		}
		
}
