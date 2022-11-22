package Modifications;


import java.sql.Connection;
import java.sql.DriverManager;

public class ControlDB {
	
	public static Connection createConnection()
	 {
	     Connection con = null;
	     String url = "jdbc:mysql://localhost:3306/ticketautocar"; //MySQL URL followed by the database name
	     String username = "root"; //MySQL username
	     String password = ""; //MySQL password
	     System.out.println("In ControlDB.java class ");
	      
	     try
	     {
	         try
	         {
	            Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
	         } 
	         catch (ClassNotFoundException e)
	         {
	            e.printStackTrace();
	         }       
	         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	         System.out.println("Printing connection object "+con);
	     } 
	     catch (Exception e) 
	     {
	        e.printStackTrace();
	     }   
	     return con; 
	 }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



