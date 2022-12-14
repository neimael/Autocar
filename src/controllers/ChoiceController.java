package controllers;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChoiceController {
	@FXML
    void new_travel(ActionEvent event) {
		choiceI.getScene().getWindow().hide();
		Stage primaryStage = null;
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
	
	@FXML
    private AnchorPane choiceI;
	
	private Parent fxml;
	
    @FXML
    void ticket_lost(ActionEvent event) {
   
    	choiceI.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/lost_ticket.fxml"));
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
    void back(ActionEvent event) {
    	choiceI.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/SignIn.fxml"));
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
}
