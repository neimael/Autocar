package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class paiementController {

    @FXML
    private AnchorPane code;
	private Parent fxml;
	
	@FXML
    private TextField card_number;

    
    @FXML
    void insert_function(ActionEvent event) {
    	code.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/CodePin.fxml"));
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
    	code.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/travel.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

}