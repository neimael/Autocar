package ConnectionDB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlDB {
	
	
	private static Connection con ;
    private static final String url = "jdbc:mysql://localhost:3306/ticketautocar"; //MySQL URL followed by the database name
    private static final String username = "root"; //MySQL username
    private static final String password = ""; //MySQL password
	
	public static Connection createConnection()
	 {
	         try
	         {
	        	 
	        	 con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	        	 System.out.println("DataBase Connection succes ! ");
	        	 
	         } 
	         catch (SQLException e)
	         {
	        	 System.out.println("Connection ERROR !");
	            e.printStackTrace();
	         }       
	         
	       
	     return con; 
	 }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



