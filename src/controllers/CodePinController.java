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

public class CodePinController {

	@FXML
    private AnchorPane pin;
	
	 @FXML
	 private TextField code_pin;
	 private Parent fxml;
	  
	 @FXML
	 void insert_pin(ActionEvent event) {

	 }
	 
	 @FXML
	 void back(MouseEvent event) {
		 pin.getScene().getWindow().hide();
	    	Stage choice = new Stage();
	    	try {
	    		fxml = FXMLLoader.load(getClass().getResource("/application/paiement.fxml"));
	    		Scene scene = new Scene(fxml);
	    		choice.setScene(scene);
	    		choice.setResizable(false);
	    		choice.show();
	    	} catch(IOException e) {
	    		e.printStackTrace();
	    	}
     }
}
