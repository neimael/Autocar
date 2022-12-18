package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ResourceBundle;


import ConnectionDB.ControlDB;
import Model.Travel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class travelController implements Initializable {

    @FXML
    private TableColumn<Travel, Time> arr_time;

    @FXML
    private TableColumn<Travel, Time> dep_time;
    
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet result = null;

    @FXML
    private TableColumn<Travel, String> name_company;

    @FXML
    private TableColumn<Travel, Float> price;

    @FXML
    private AnchorPane result_travel;

	private Parent fxml;
	
	 @FXML
	 private TableView<Travel> search_travel;

    @FXML
    void reserver(ActionEvent event) {
    	result_travel.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/latest_travel.fxml"));
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
        ObservableList<Travel> data = FXCollections.observableArrayList();

    	conn = ControlDB.createConnection();

        data = FXCollections.observableArrayList();
        try{
        	
        	String sql = "SELECT company_name,depart_time,arriving_time,price FROM travel WHERE villedepart = ? and villedarriver = ? and date_travel = ? and number_places >= ? ";
    		
   		 	statement = conn.prepareStatement(sql);
   		 	statement.setString(1, Travel.getCity_dep());
   		 	statement.setString(2, Travel.getCiy_arr());
   		 	statement.setString(3, Travel.getDate_travel().toString());
   		 	statement.setInt(4, Travel.getNum_places());
   		 	result = statement.executeQuery();
		      
         while(result.next()){
            data.add(new Travel(result.getString("company_name"),result.getTime("depart_time"),result.getTime("arriving_time"),Float.parseFloat(result.getString("price")) ));
            search_travel.setItems(data);
         }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void showListe() {

    	name_company.setCellValueFactory(new PropertyValueFactory<Travel,String>("company_name"));
    	dep_time.setCellValueFactory(new PropertyValueFactory<Travel,Time>("dep_time"));
    	arr_time.setCellValueFactory(new PropertyValueFactory<Travel,Time>("arr_time"));
    	price.setCellValueFactory(new PropertyValueFactory<Travel,Float>("price"));
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showListe();
		load();
	}

	
}
