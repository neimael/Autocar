package controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.lang.RuntimeException;
import ConnectionDB.ControlDB;
import Model.Reservation;
import Model.Travel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class travelController implements Initializable {
	
	
	ObservableList<Travel> travel;
	private Connection conn =null;
    private PreparedStatement statement;
    private ResultSet result = null;
 
   
   
    @FXML
	private TableView<Reservation> latest_travel;
	 @FXML
	 private TableView<Travel> search_travel;
	 
	   @FXML
	    private TableColumn<Travel, Integer> id_table;
	    
	    @FXML
	    private TableColumn<Travel, String> name_company;

	    @FXML
	    private TableColumn<Travel, Time> dep_time;

	    @FXML
	    private TableColumn<Travel, Time> arr_time;

	    @FXML
	    private TableColumn<Travel, Float> price;


    @FXML
    private AnchorPane result_travel;
    
    @FXML
    private Button reserver;

	private Parent fxml;
	
	
	 
	 
	 
	  @FXML
	    void clickedColumn(MouseEvent event) {
		  
		  Travel travel= search_travel.getSelectionModel().getSelectedItem();
		  
		  try{
			  
		  if(travel==null) {
			  JOptionPane.showMessageDialog(null, "Nothing is selected", "Error Message",JOptionPane.ERROR_MESSAGE);
  		  } else {
  			  
  			Integer id_table = Travel.getId();
  			String company_name = Travel.getCompany_name();
  			Time dep_time = Travel.getDep_time();
  			Time arr_time = Travel.getArr_time();
  			Float price= Travel.getPrice();
  			
  			
  		   JOptionPane.showMessageDialog(null, "Successfully Selected !", "Success Message",JOptionPane.INFORMATION_MESSAGE);}
  			
  		} catch(Exception e)  {
  			e.printStackTrace();
  		 }
 }
	  
	  @FXML
	    private PreparedStatement pst;
	    private Connection con;
	    private ResultSet rst=null;
	 
	 
		  
		  @FXML
		    public void reserver(ActionEvent event)  {
		      
			
	        	 Stage choice = new Stage();
	        	 
	        	
		         try { 
		        		
		        		 
		          JOptionPane.showMessageDialog(null, "Successfully reserved !!", "Success Message",JOptionPane.INFORMATION_MESSAGE);
			   
	               fxml= FXMLLoader.load(getClass().getResource("/application/latest_travel.fxml"));
		    		Scene scene = new Scene(fxml);
		    		choice.setScene(scene);
		    		Image image = new Image("img/icon.png");
					choice.getIcons().add(image);
		    		choice.setResizable(false);
		    		choice.initStyle(StageStyle.UNDECORATED);
		    		choice.show();
		    	} catch(IOException e) {
		    		e.printStackTrace();
		    	}  
		         result_travel.getScene().getWindow().hide();
		    	
		        	 
		         }
		        
 
		          
		          
		            
		            	
		            
    @FXML
    void back(MouseEvent event) {
    	
    	result_travel.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/SearchTravel.fxml"));
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
    
       
    
    
    
    
    private void load(){
    	
        ObservableList <Travel> travel = FXCollections.observableArrayList();

    	conn = ControlDB.createConnection();

    	travel = FXCollections.observableArrayList();
       
        
        try{
        	
        	String sql = "SELECT id_travel,company_name,depart_time,arriving_time,price FROM travel WHERE villedepart = ? and villedarriver = ? and date_travel = ? and number_places >= ? ";
    		
        	
        	
        	statement = conn.prepareStatement(sql);
        	
        	
   		 	statement.setString(1, Travel.getCity_dep());
   		 	statement.setString(2, Travel.getCity_arr());
   		 	statement.setObject(3, Travel.getDate_travel());
   		 	statement.setFloat(4, Travel.getNum_places());
   		 	result = statement.executeQuery();
   		 	
   		
         while(result.next()){
            travel.add(new Travel(result.getInt("id_travel"),result.getString("company_name"),result.getTime("depart_time"),result.getTime("arriving_time"),result.getFloat("price")));
            
         }
         search_travel.setItems(travel);
         showListe();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
   
    
    
    // this function is  to initialize the List
    public void showListe() {

    	id_table.setCellValueFactory(new PropertyValueFactory<Travel,Integer>("id"));
    	name_company.setCellValueFactory(new PropertyValueFactory<Travel,String>("company_name"));
    	dep_time.setCellValueFactory(new PropertyValueFactory<Travel,Time>("dep_time"));
    	arr_time.setCellValueFactory(new PropertyValueFactory<Travel,Time>("arr_time"));
    	price.setCellValueFactory(new PropertyValueFactory<Travel,Float>("price"));
       
    	
   }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  conn= ControlDB.createConnection();
		  load();
		showListe();
		
		
	 }




	

	
}
