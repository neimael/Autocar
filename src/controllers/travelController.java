package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class travelController {

    @FXML
    private TableColumn<?, ?> arr_time;

    @FXML
    private TableColumn<?, ?> dep_time;

    @FXML
    private TableColumn<?, ?> name_company;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private AnchorPane result_travel;

    @FXML
    private TableColumn<?, ?> route;

	private Parent fxml;

    @FXML
    void reserver(ActionEvent event) {
    	result_travel.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/paiement.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
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
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

}
