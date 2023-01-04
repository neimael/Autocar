package Model;

import java.sql.Time;
import java.time.LocalDate;



public class Reservation {
	
	    protected static int id_des;                   
		protected static String CIN;
		protected static String carname;
		protected static String depart_city;
		protected static String arr_city;
		protected static  Time depart_time;
		protected static Time arrive_time;
		protected static  float price_dh;
		protected static int  N_places;
	    protected static LocalDate Date_travel; 
		
		
		

	
		
		
		public Reservation(String carname,String depart_city,String arr_city, Time depart_time, Time arrive_time, float price_dh) {
			
			
			Reservation.carname = carname;
			Reservation.depart_city=depart_city;
			Reservation.arr_city=arr_city;
			Reservation.depart_time = depart_time;
			Reservation.arrive_time = arrive_time;
			Reservation.price_dh = price_dh;
			
		}
          
		
		
public Reservation(String carname, Time depart_time, Time arrive_time, float price_dh) {
			
			
			Reservation.carname = carname;
			Reservation.depart_time = depart_time;
			Reservation.arrive_time = arrive_time;
			Reservation.price_dh = price_dh;
			
		}
		



		public static String getDepart_city() {
			return depart_city;
		}



		public static void setDepart_city(String depart_city) {
			Reservation.depart_city = depart_city;
		}



		public static String getArr_city() {
			return arr_city;
		}



		public static void setArr_city(String arr_city) {
			Reservation.arr_city = arr_city;
		}



		public static int getId_des() {
			return id_des;
		}


		


		public static void setId_des(int id_des) {
			Reservation.id_des = id_des;
		}






		public static String getCIN() {
			return CIN;
		}


		public static void setCIN(String cIN) {
			CIN = cIN;
		}


		public static String getCarname() {
			return carname;
		}


		public static void setCarname(String carname) {
			Reservation.carname = carname;
		}


		public static Time getDepart_time() {
			return depart_time;
		}


		public static void setDepart_time(Time depart_time) {
			Reservation.depart_time = depart_time;
		}


		public static Time getArrive_time() {
			return arrive_time;
		}


		public static void setArrive_time(Time arrive_time) {
			Reservation.arrive_time = arrive_time;
		}


		public static float getPrice_dh() {
			return price_dh;
		}


		public static void setPrice_dh(float price_dh) {
			Reservation.price_dh = price_dh;
		}


		public static int getN_places() {
			return N_places;
		}


		public static void setN_places(int n_places) {
			N_places = n_places;
		}


		public static LocalDate getDate_travel() {
			return Date_travel;
		}


		public static void setDate_travel(LocalDate date_travel) {
			Date_travel = date_travel;
		}
		
		
		
		
		
}