package Model;

public class payement {
	   protected int id_payement;
		protected int Num_card;
		
		
		
		
        public payement() {
			
		}
        
		public payement(int num_card) {
			
			Num_card = num_card;
		}

		public payement(int id_payement, int num_card) {
			
			this.id_payement = id_payement;
			Num_card = num_card;
		}
		
		public int getId_payement() {
			return id_payement;
		}
		public void setId_payement(int id_payement) {
			this.id_payement = id_payement;
		}
		public int getNum_card() {
			return Num_card;
		}
		public void setNum_card(int num_card) {
			Num_card = num_card;
		}
		
		
		
}
