package Model;

public class Storage_destination {
	   protected int id_Storage;
		protected String CIN;
		protected String carname;
		protected String depart_time;
		protected int arrive_time;
		protected String price_dh;
		
		
		public Storage_destination() {
			super();
		}
		
		
		public Storage_destination(int id_Storage) {
			super();
			this.id_Storage = id_Storage;
		}
		
		
		
		public Storage_destination(String cIN, String carname, String depart_time, int arrive_time, String price_dh) {
			super();
			CIN = cIN;
			this.carname = carname;
			this.depart_time = depart_time;
			this.arrive_time = arrive_time;
			this.price_dh = price_dh;
		}
		
		
		public Storage_destination(int id_Storage, String cIN, String carname, String depart_time, int arrive_time,
				String price_dh) {
			super();
			this.id_Storage = id_Storage;
			CIN = cIN;
			this.carname = carname;
			this.depart_time = depart_time;
			this.arrive_time = arrive_time;
			this.price_dh = price_dh;
		}
		
		
		public int getId_Storage() {
			return id_Storage;
		}
		
		
		public void setId_Storage(int id_Storage) {
			this.id_Storage = id_Storage;
		}
		
		
		public String getCIN() {
			return CIN;
		}
		
		public void setCIN(String cIN) {
			CIN = cIN;
		}
		
		public String getCarname() {
			return carname;
		}
		
		
		
		public void setCarname(String carname) {
			this.carname = carname;
		}
		
		
		public String getDepart_time() {
			return depart_time;
		}
		
		
		public void setDepart_time(String depart_time) {
			this.depart_time = depart_time;
		}
		
		public int getArrive_time() {
			return arrive_time;
		}
		
		
		public void setArrive_time(int arrive_time) {
			this.arrive_time = arrive_time;
		}
		
		
		public String getPrice_dh() {
			return price_dh;
		}
		
		
		public void setPrice_dh(String price_dh) {
			this.price_dh = price_dh;
		}
		
		
		
}
