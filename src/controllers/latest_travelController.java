package controllers;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
 import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ConnectionDB.ControlDB;
import Model.Reservation;
import Model.Travel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class latest_travelController implements Initializable{
	
	
	private Connection conn;
    private PreparedStatement statement;
    private ResultSet result = null;
	 
    @FXML
    private AnchorPane result_travel;
    

	@FXML
	private TableView<Reservation> latest_travel;

    @FXML
    private TableColumn<Reservation, String> cin_name_campany;
    

    @FXML
    private TableColumn<Reservation, String> depart_city;

    @FXML
    private TableColumn<Reservation, String> arr_city;

    @FXML
    private TableColumn<Reservation, Time> dep_time;

    @FXML
    private TableColumn<Reservation, Time> arr_time;

    @FXML
    private TableColumn<Reservation, Float> price;
    
    @FXML
    private Button pay;
    
    private Parent fxml;
    
 
   

   


	
      // Event Listener on Button.onAction
	 @FXML
	    public void pay(ActionEvent event) {
		  
	    	Stage choice = new Stage();
	    	try {
	    		fxml = FXMLLoader.load(getClass().getResource("/application/paiement.fxml"));
	    		Scene scene = new Scene(fxml);
	    		choice.setScene(scene);
	    		choice.setResizable(false);
	    		Image image = new Image("img/icon.png");
				choice.getIcons().add(image);
	    		choice.initStyle(StageStyle.UNDECORATED);
	    		choice.show();
	    	} catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	 latest_travel.getScene().getWindow().hide();

	    }
	
	    
	
		   
	 

	// Event Listener on ImageView.onMousePressed
	@FXML
	public void back(MouseEvent event) {
		result_travel.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/travel.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
  		e.printStackTrace();
    	}
	}
	
	  @FXML
	   public void tableEvent(MouseEvent event) {
		  
            Reservation reservation = latest_travel.getSelectionModel().getSelectedItem();
		  
		  if(reservation==null) {
			  JOptionPane.showMessageDialog(null, "Nothing is selected", "Error Message",JOptionPane.ERROR_MESSAGE);
  		} else {
  			
  			String cin_name_campany = reservation.getCarname();
  			
  			String dep_city=reservation.getDepart_city();  
  			String arr_city=reservation.getArr_city();  
  			Time dep_time= reservation.getDepart_time();
  			Time arr_time =reservation.getArrive_time();
  			Float price=reservation.getPrice_dh();
  			
  			JOptionPane.showMessageDialog(null, "Successfully Selected !", "Success Message",JOptionPane.INFORMATION_MESSAGE);
  		
  		}

	    }

	  @FXML
	  public void loaddata() {
		 Connection conn = ControlDB.createConnection();
		  ObservableList <Reservation> reservation  = FXCollections.observableArrayList();
		  
		  
		  
		  
	        try{
	        
	        	
	        	String sql = "SELECT travel.company_name,travel.depart_time,travel.arriving_time,travel.villedepart,travel.villedarriver,travel.price FROM reservation,travel";
	    		PreparedStatement statement = conn.prepareStatement(sql);
	    	
	   		    ResultSet result = statement.executeQuery();
			      
	         while(result.next()){
	        	 reservation.add( new Reservation(result.getString("travel.company_name"),result.getString("travel.villedepart"),result.getString("travel.villedarriver"),result.getTime("travel.depart_time"),result.getTime("travel.arriving_time"),result.getFloat("travel.price")));
	          }
	    
	         latest_travel.setItems(reservation);
	         showListres();
	        
			  
	        } catch (SQLException e) {
	        	  System.out.println("SQLException: " + e.getMessage());
	 	         System.out.println("SQLState: " +  e.getSQLState());
	 	         System.out.println("travelError: " + e.getErrorCode());
	        }
	       
	         
	     
	        }
		  
	  

	  
	  public void showListres() {
		  
		  cin_name_campany.setCellValueFactory( new  PropertyValueFactory<Reservation,String>("carname"));
		  depart_city.setCellValueFactory( new  PropertyValueFactory<Reservation,String>("depart_city"));
		  arr_city.setCellValueFactory( new  PropertyValueFactory<Reservation,String>("arr_city"));
		  dep_time.setCellValueFactory( new  PropertyValueFactory<Reservation,Time>("depart_time"));
		  arr_time.setCellValueFactory( new  PropertyValueFactory<Reservation,Time>("arrive_time"));
		  price.setCellValueFactory(new PropertyValueFactory<Reservation,Float>("price_dh") );
		 
	  }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conn = ControlDB.createConnection();
		showListres();
		loaddata();
		
	}
	
	
    
}  	  
        	
          
      
	
	
 
	 
	 
	 
	