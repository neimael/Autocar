package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;




import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import ConnectionDB.ControlDB;
import Model.Travel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CRUDController implements Initializable {
     
	
	
	@FXML
    private TableView<Travel> table;

    @FXML
    private TableColumn<Travel,Integer> IDColumn;

    @FXML
    private TableColumn<Travel,String> NameCarColumn;

    @FXML
    private TableColumn<Travel,Time> T_departColumn;

    @FXML
    private TableColumn<Travel,Time> T_arriverColumn;

    @FXML
    private TableColumn<Travel,Float> PriceColumn;

    @FXML
    private TableColumn<Travel,String> V_departColumn;

    @FXML
    private TableColumn<Travel,String> V_arriveColumn;

    @FXML
    private TableColumn<Travel,LocalDate> D_date;

    @FXML
    private TableColumn<Travel,Integer> D_places;

   

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSAVE;

    @FXML
    private Button btnUPDATE;

    

    @FXML
    private TextField txName;

    @FXML
    private TextField txdepart;

    @FXML
    private TextField txarriver;

    @FXML
    private TextField txPrice;

    @FXML
    private TextField txVdepart;

    @FXML
    private TextField txVarrive;

    @FXML
    private TextField dateT;

    @FXML
    private TextField places;

    @FXML
    private PreparedStatement pst;
    private Connection con;
    private ResultSet rst;
  
    
    @FXML
    void SAVE(ActionEvent event) {
     con=ControlDB.createConnection();
    	
   String Name_of_company=  txName.getText();
   String time_depart=  txdepart.getText();
   String time_darriver=  txarriver.getText();
   String Ville_depart=  txVdepart.getText();
   String Price=  txPrice.getText();
   String Places = places.getText();
   String Ville_darriver=txVarrive.getText();
   String date_travel=dateT.getText();
   try {
	String   sql="Insert INTO travel(company_name,depart_time,arriving_time,price,number_places,villedepart,villedarriver,date_travel)values(?,?,?,?,?,?,?,?)";
   	PreparedStatement pst=con.prepareStatement(sql);
   	pst.setString(1, Name_of_company);
   	pst.setString(2, time_depart);
   	pst.setString(3, time_darriver);
   	pst.setString(4, Price);
   	pst.setString(5, Places);
   	pst.setString(6, Ville_depart);
   	pst.setString(7, Ville_darriver);
   	pst.setString(8, date_travel);
   	
   	pst.execute();
   	
     Alert alert=new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Test Conection");
     
     
     alert.setHeaderText("travel");
     alert.setContentText("add text");
     
     alert.showAndWait();
     
     
    
     txName.setText("");
     txdepart.setText("");
     txVarrive.setText("");
     txVdepart.setText("");
     txPrice.setText("");
     txarriver.setText("");
     places.setText("");
     dateT.setText("");
     txName.requestFocus();
     
     showList();
     table();

   }catch(Exception e) {
	   e.printStackTrace();
   }
 
    }
    
    
    
    
    @FXML
    void Delete(ActionEvent event) {
     int myIndex =table.getSelectionModel().getSelectedIndex();
    int  id= Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
     try
     {
         pst = con.prepareStatement("delete from travel where id_travel = ? ");
         pst.setInt(1, id);
         pst.executeUpdate();

         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("travel Registationn");


         alert.setHeaderText("travel Registation");
         alert.setContentText("Deletedd!");

         alert.showAndWait();
         table();
     }
     catch (SQLException ex)
     {
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
     }
 }
  


   
    
    
   


    
    
   
   public void table() {
    	
	  con= ControlDB.createConnection();
	   
	   ObservableList<Travel> travels=FXCollections.observableArrayList();
	 
	   try {
		   String sql = "select * FROM travel";
		   
		   pst=con.prepareStatement(sql);
		   
		   rst=pst.executeQuery();
		   
		while(rst.next()) {
			 
			 Travel tl=new Travel(rst.getInt("id_travel"),rst.getString("company_name"),rst.getTime("depart_time"),rst.getTime("arriving_time"),rst.getFloat("price"),rst.getInt("number_places"),rst.getString("villedepart"),rst.getString("villedarriver"),LocalDate.parse(rst.getDate("date_travel").toString()));
			 travels.add(tl);
			 
		} 
		
		table.setItems(travels);
		showList();
		
		
		
	   
	   }catch(SQLException e) {
		   
		   System.out.println("SQLException: " + e.getMessage());
	         System.out.println("SQLState: " + e.getSQLState());
	         System.out.println("travelError: " + e.getErrorCode());
	   }
	   
	   
	  
	// select 
       
      table.setRowFactory(tv->{
      	TableRow<Travel> myRow = new TableRow<>();
      	myRow.setOnMouseClicked(event->
      	{
      		if(event.getClickCount() == 1 &&(!myRow.isEmpty())) {
     			
     			int myIndex = table.getSelectionModel().getSelectedIndex();
    			int id= Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
    			
    			txName.setText(table.getItems().get(myIndex).getCompany_name());
    			txarriver.setText(table.getItems().get(myIndex).getArr_time().toString());
    			txdepart.setText(table.getItems().get(myIndex).getDep_time().toString());
    			txVdepart.setText(table.getItems().get(myIndex).getCity_dep());
    			txVarrive.setText(table.getItems().get(myIndex).getCity_arr());
    			 txPrice.setText(String.valueOf(table.getItems().get(myIndex).getPrice()));
    			 dateT.setText(table.getItems().get(myIndex).getDate_travel().toString());
    			 places.setText(String.valueOf(table.getItems().get(myIndex).getNum_places()));  			
   		}
      	  
      });
     
   	  return myRow;
     });
       
     
 
    }
    
    public void showList() {
    	
		    IDColumn.setCellValueFactory(new PropertyValueFactory<Travel,Integer>("id"));
			NameCarColumn.setCellValueFactory(new PropertyValueFactory<Travel,String>("company_name"));
			T_departColumn.setCellValueFactory(new PropertyValueFactory<Travel,Time>("dep_time"));
			T_arriverColumn.setCellValueFactory(new PropertyValueFactory<Travel,Time>("arr_time"));
			PriceColumn.setCellValueFactory(new PropertyValueFactory<Travel,Float>("price"));
			V_departColumn.setCellValueFactory(new PropertyValueFactory<Travel,String>("city_dep"));
			PriceColumn.setCellValueFactory(new PropertyValueFactory<Travel,Float>("price"));
			V_arriveColumn.setCellValueFactory(new PropertyValueFactory<Travel,String>("city_arr"));
			D_date.setCellValueFactory(new PropertyValueFactory<Travel,LocalDate>("date_travel"));
			D_places.setCellValueFactory(new PropertyValueFactory<Travel,Integer>("num_places"));
	   }

   
    
    
    
    
@FXML
void UPDATE(ActionEvent event) {
      con= ControlDB.createConnection();
       int myIndex = table.getSelectionModel().getSelectedIndex();
      int  id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
       
  	String Name_of_company=  txName.getText();
    String time_depart=  txdepart.getText();
    String time_darriver=  txarriver.getText();
    String Ville_depart=  txVdepart.getText();
    String Price=  txPrice.getText();
    String Ville_darriver=txVarrive.getText();
    String Date_depart= dateT.getText();
	String num_place=places.getText();
    
       try
       {
    	   
    	   String   sql="update travel set company_name=?,depart_time=?,arriving_time=?,price=?,villedepart=?,villedarriver=?,date_travel=?,number_places=? where id_travel=?";
    	    pst=con.prepareStatement(sql);
    	   	pst.setString(1, Name_of_company);
    	   	pst.setString(2, time_depart);
    	   	pst.setString(3, time_darriver);
    	   	pst.setString(4, Price);
    	   	pst.setString(5, Ville_depart);
    	   	pst.setString(6, Ville_darriver);
    	   	pst.setString(7, Date_depart);
    	   	pst.setString(8, num_place);
    	   	pst.setInt(9, id);
    	   	pst.executeUpdate();

           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Travel Registation");


           alert.setHeaderText("Travel Registation");
           alert.setContentText("Updateddd!");

           alert.showAndWait();
          table();
          
          
       }
       catch (SQLException ex)
       {
    	   System.out.println("SQLException: " + ex.getMessage());
	         System.out.println("SQLState: " + ex.getSQLState());
	         System.out.println("VendorError: " + ex.getErrorCode());}
           
           
       }
       
       
       @Override
      	public void initialize(URL arg0, ResourceBundle arg1) {
      		// TODO Auto-generated method stub
      		ControlDB.createConnection();
      		showList();
           	 table();
    
}}
    	
 
       	
       
      	
    	
   
    	
    	
    	
    	
    	
    	
  
   
   	
   
    	
    	
    	
    	

    

   
    
   
    



