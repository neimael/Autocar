package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.Travel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SearchTravelController implements Initializable{

	@FXML
    private ComboBox<String> arr_city;

    @FXML
    private DatePicker date_travel;

    @FXML
    private ComboBox<String> dep_city;

    @FXML
    private Spinner<Integer> num_ticket;

    @FXML
    private AnchorPane searchT;

	private Parent fxml;
	
	

    @FXML
    void search_travel(ActionEvent event) {
    	
    	if(dep_city.getSelectionModel().isEmpty() || arr_city.getSelectionModel().isEmpty()) {
			 JOptionPane.showMessageDialog(null, "You have to choose your destination !", "Error Message",JOptionPane.ERROR_MESSAGE);
    	}
    	else {
    	
    		String selected_dep = dep_city.getSelectionModel().getSelectedItem().toString();
    		Travel.setCity_dep(selected_dep);
    		
    		String selected_arr = arr_city.getSelectionModel().getSelectedItem().toString();
    		Travel.setCiy_arr(selected_arr);
    		
    		int current_value = num_ticket.getValue();
    		Travel.setNum_places(current_value);
    		
    		
    		LocalDate myDate = date_travel.getValue();
    		Travel.setDate_travel(myDate);
    		
    		
    		if(selected_arr.equals(selected_dep)) {
				 JOptionPane.showMessageDialog(null, "Departure City Shouldn't be the same As Arrival City !", "Error Message",JOptionPane.ERROR_MESSAGE);
    		}
    		else if(myDate == null) {
				 JOptionPane.showMessageDialog(null, "Choose date of travel First !", "Error Message",JOptionPane.ERROR_MESSAGE);
    		}
    		else {
    			try {
    				Stage choice = new Stage();
    			fxml = FXMLLoader.load(getClass().getResource("/application/travel.fxml"));
        		Scene scene = new Scene(fxml);
        		choice.initStyle(StageStyle.UNDECORATED);
        		choice.setScene(scene);
        		Image image = new Image("img/icon.png");
    			choice.getIcons().add(image);
        		choice.setResizable(false);
        		choice.show();
        		
    		} catch(IOException e) {
        		e.printStackTrace();
        	} 
    			searchT.getScene().getWindow().hide();
    	    	
    			}
    	}
    		
    		
    		
    	
    }
    
    @FXML
    void back(ActionEvent event) {
    	searchT.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/Choice.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.setScene(scene);
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		String [] cities = {"Agadir","Casablanca","Rabat","Tanger","Marrakech","El Jadida","Asfi","Fès"};
		arr_city.getItems().addAll(cities);
		dep_city.getItems().addAll(cities);
		
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		valueFactory.setValue(1);
		num_ticket.setValueFactory(valueFactory);
		
		date_travel.setDayCellFactory(param -> new DateCell() {
		    private LocalDate now = LocalDate.now();

		    @Override
		    public void updateItem(LocalDate date, boolean empty) {
		        super.updateItem(date, empty);
		         setDisable(date.compareTo(now) < 0 );
		    }
		});
		
	}

}
