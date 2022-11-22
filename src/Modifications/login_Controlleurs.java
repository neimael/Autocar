package Modifications;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.log_in;
import Modifications.ControlDB;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

	@SuppressWarnings("unused")
	public class login_Controlleurs  {
	  
		    @FXML
		    private TextField cin;

		    @FXML
		    private TextField password;

		    @FXML
		    private AnchorPane sign_in;
			
			private Parent fxml;

		    @FXML
		    
		public String enregistrerlog(log_in log)
	     {
	         String CIN = log.getCIN();
	         String password = log.getPassword();
	         Connection con = null;
	         PreparedStatement preparedStatement = null;         
	         try
	         {
	             con = ControlDB.createConnection();
	             String query = "insert into log_in(id_log,CIN,password) values (NULL,?,?)"; //Insert user details into the table 'USERS'
	             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	             preparedStatement.setString(1, CIN);
	             preparedStatement.setString(2, password);
	            
	             int i= preparedStatement.executeUpdate();
	             
	             if (i!=0)  //Just to ensure data has been inserted into the database
	             return "SUCCESS"; 
	         }
	         catch(SQLException e)
	         {
	            e.printStackTrace();
	         }       
	         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	     }
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
