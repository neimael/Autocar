package Model;

import java.sql.Time;
import java.time.LocalDate;


public class Travel {
	private static int id;
	private static String company_name;
	private static String city_dep;
	private static String city_arr;
	private static Time dep_time;
	private static Time arr_time;
	private static float price;
	private static int num_places;
	private static LocalDate date_travel;
	
	
	
	public Travel (int id,String company_name, Time dep_time, Time arr_time, float price) {
		Travel.id= id;
		Travel.company_name = company_name;
		Travel.dep_time = dep_time;
		Travel.arr_time = arr_time;
		Travel.price = price;
		
	}
	

	public Travel (int id,String company_name, Time dep_time, Time arr_time, float price,int num_place,String city_dep,String city_arr,LocalDate date_travel) {
		Travel.id= id;
		Travel.company_name = company_name;
		Travel.dep_time = dep_time;
		Travel.arr_time = arr_time;
		Travel.price = price;
		Travel.num_places=num_place;
		Travel.date_travel=date_travel;
		Travel.city_dep=city_dep;
		Travel.city_arr=city_arr;
		
	}
	
	
	
	static public int getId() {
		return id;
	}


	static public void setId(int id) {
		Travel.id = id;
	}


	static public String getCompany_name() {
		return company_name;
	}


	public static void setCompany_name(String company_name) {
		Travel.company_name = company_name;
	}


	static public String getCity_dep() {
		return city_dep;
	}


	static public void setCity_dep(String city_dep) {
		Travel.city_dep = city_dep;
	}


	static public String getCity_arr() {
		return city_arr;
	}


	static public void setCiy_arr(String city_arr) {
		Travel.city_arr = city_arr;
	}


	static public Time getDep_time() {
		return dep_time;
	}


	static public void setDep_time(Time dep_time) {
		Travel.dep_time = dep_time;
	}


	static public Time getArr_time() {
		return arr_time;
	}


	static public void setArr_time(Time arr_time) {
		Travel.arr_time = arr_time;
	}


	static public float getPrice() {
		return price;
	}


	static public void setPrice(float price) {
		Travel.price = price;
	}


	static public int getNum_places() {
		return num_places;
	}


	static public void setNum_places(int num_places) {
		Travel.num_places = num_places;
	}


	static public LocalDate getDate_travel() {
		return date_travel;
	}


	static public void setDate_travel(LocalDate date_travel) {
		Travel.date_travel = date_travel;
	}
	
	
	
	
	
}
