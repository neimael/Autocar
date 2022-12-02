package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SearchTravelController {

    @FXML
    private ChoiceBox<?> arr_city;

    @FXML
    private DatePicker date_travel;

    @FXML
    private ChoiceBox<?> dep_city;

    @FXML
    private Spinner<?> num_ticket;

    @FXML
    private AnchorPane searchT;

	private Parent fxml;

    @FXML
    void search_travel(ActionEvent event) {
    	searchT.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
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

}
